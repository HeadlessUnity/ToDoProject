package toDoProject;

import java.util.ArrayList;
import java.util.Scanner;



public class ToDoList {
	Scanner sc = new Scanner(System.in);
	String input; 

	private ArrayList<Task> list = new ArrayList<Task>();


	public void addTask(Task task) {
		list.add(task);
	}
	
	public void removeTask(String title) {
		System.out.println(list.indexOf(findTask(title)));
		list.remove(findTask(title));
		
		

	}

	public void editTask(String name) {

		findTask(name);
		System.out.println("Found taskname: " + name.toString());
		System.out.println("What do you want to change? (name,description,endDate");
		input = sc.nextLine().toLowerCase();
		switch (input) {
		case "name":
			
			input = sc.nextLine().toLowerCase();
			
			break;

		case "description":
			
			input = sc.nextLine().toLowerCase();

			break;
			
		case "endDate":
			
			input = sc.nextLine().toLowerCase();

			break;

		default:
			break;
		}
		input = sc.nextLine().toLowerCase();


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


