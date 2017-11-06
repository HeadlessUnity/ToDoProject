package toDoProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ToDoList {

	Scanner sc = new Scanner(System.in);
	String input; 
	int inputInt;

	private ArrayList<Task> list = new ArrayList<Task>();

	public void addTask(Task task) {
		list.add(task);
	}

	public void sortTodoByEndDateList() {
		Collections.sort(list, new Comparator<Task>(){
			public int compare(Task t1, Task t2) {
				return t1.getEndDate().compareTo(t2.getEndDate());
			}			
		});
		System.out.println(list);
	}




	public void checkStatus() {
		//checks task status		
		Iterator<Task> it = list.iterator(); 
		while (it.hasNext()) {
			Task task = it.next();
			if (task.getEndDate().isBefore(task.getStartDate())){

				System.out.println("USER_NOTICE: Found expired task: " + task.getTitle() +"\nChanging task: " + task.getTitle() + " to EXPIRED.");
				task.setStatus(Status.EXPIRED);				
			}
		}
	}


	public void removeExpDates() {
		//checks if a task has past its expiry date and if so removes it from todolist
		Iterator<Task> it = list.iterator(); 
		while (it.hasNext()) {
			Task task = it.next();
			if (task.getStatus() == Status.EXPIRED || task.getStatus() == Status.DONE){

				System.out.println("USER_WARNING: Found expired task: " + task.getTitle() +".\nRemoving....");
				it.remove();
			}
		}
	}

	public void removeTask(String title) {
		//deletes a task from todolist
		System.out.println(list.indexOf(findTask(title)));
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
		//prints all tasks to screen
		for(Task l : list)
			System.out.println(l.toString());
	}

	public Task findTask(String title){
		//takes a taskname and searches the todolist to find it 
		//returns the taskobjekt if found else returns null 
		title =title.trim();		
		for (Task task : list) {
			if (task.getTitle().equalsIgnoreCase(title)) {
				return task;
			}			
		}
		return null;
	}
}


