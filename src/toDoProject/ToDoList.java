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
	
// TODO fix this mother...
//	public void deleteTask(String title) {
//		findTask(name)
//
//	}
//TODO
	public void editTask(String name) {

		findTask(name);
		System.out.println("Found taskname: " + name.toString());
		System.out.println("What do you want to change? (name,description,endDate");
		input = sc.nextLine().toLowerCase();
		switch (input) {
		case "name":
			
			input = sc.nextLine().toLowerCase();
			
			break;

		case "despription":
			
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


	public String findTask(String title){
		title =title.trim();

		for (Task task : list) {
			if (task.getTitle().equals(title)) {
				System.out.println(task.toString());
				return title;
			}
			else {			
				return "Task not Found";
			}
		}
		return null;
	}

}


