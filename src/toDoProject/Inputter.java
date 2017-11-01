package toDoProject;

import java.util.Scanner;

public class Inputter {
	
	
	private String toDoTitle;
	private String toDoDescription;
	private int endDate;
	private boolean running = true;
	
	public void startToDo() {
		while (running) {
			ToDoList todo = new ToDoList();
			System.out.println("What would you like \"To Do\"?");
			System.out.println("--Type \"help\" if you wish to see the command list--");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine().toLowerCase();
			
			switch (input) {
				case "add":
					System.out.println("Choose a title");
					toDoTitle = sc.nextLine();
					System.out.println("Write a short description");
					toDoDescription = sc.nextLine();
					System.out.println("How many days should this take?");
					endDate = sc.nextInt();
					Task task = new Task(toDoTitle, toDoDescription, endDate);
					todo.addTask(task);
					System.out.println("To Do added!");
					break;
				case "remove":
					System.out.println("Removing task");
					break;
				case "list":
					System.out.println("Listing all tasks");
					break;
				case "find":
					toDoTitle = sc.nextLine();
					System.out.println("Looking for a specific task");
					todo.findTask(toDoTitle);					
					break;
				case "edit":
					System.out.println("Editing the task");
					break;
				case "help":
					System.out.println("This is the help section");
					break;
				case "exit":
					System.out.println("Exiting program");
					running = false;
					break;
		
				default:
				break;
			}
		}
	}
}
