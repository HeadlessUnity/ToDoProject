package toDoProject;

import java.util.ArrayList;
import java.util.Scanner;



public class ToDoList {
	Scanner sc = new Scanner(System.in);
	String input; 
	int inputInt;

	private ArrayList<Task> list = new ArrayList<Task>();


	public void addTask(Task task) {
		list.add(task);
	}
	



	public void removeExpDates() {
		for (Task task : list) {
			if (task.getStatus() == Status.EXPIRED){
				System.out.println("NOTICE: Found expired task: " + task.getTitle() +".\nRemoving...");
				removeTask(task.getTitle());
				
			}
		}
	}

	public void removeTask(String title) {
		list.remove(findTask(title));
		
		

	}


	public void editTask() {
		System.out.println("Enter task to edit ");
		String searchString = sc.nextLine().toLowerCase();
		Task foundTask = this.findTask(searchString);
		System.out.println("Found taskname: " + searchString.toString());
		System.out.println("What do you want to change? (name,description,date)");
		input = sc.nextLine().toLowerCase();
		switch (input) {
		case "name":
			System.out.println("Enter new Name:");
			input = sc.nextLine();
			foundTask.setTitle(input);			
			
			break;

		case "description":
			System.out.println("Enter new description:");
			input = sc.nextLine();
			foundTask.setDescription(input);
			break;
			
		case "date":
			System.out.println("Enter number of days to set new enddate:");
			inputInt = sc.nextInt();
			foundTask.setEndDate(foundTask.getEndDate().plusDays(inputInt));
			break;

		default:
			break;
		}
		

	}
	public void printAll() {
		for(Task l : list)
			System.out.println(l.toString());
	}






	public Task findTask(String title){

		title =title.trim();
		
		for (Task task : list) {
			

			if (task.getTitle().equalsIgnoreCase(title)) {

				return task;
			}

			
		}
		return null;
	}

}


