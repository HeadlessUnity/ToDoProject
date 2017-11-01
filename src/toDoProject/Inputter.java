package toDoProject;

import java.util.Scanner;

public class Inputter {
	
	
	private String toDoTitle;
	private String toDoDescription;
	private long endDate;
	private boolean running = true;
	
	public void startToDo() {
		ToDoList todo = new ToDoList();
		System.out.println(" +-------------------------------------+");
		System.out.println(" | Type \"help\" to see the command list |");
		System.out.println(" |     Type \"exit\" to exit program     |");
		System.out.println(" +-------------------------------------+\n");
		while (running) {
			System.out.println("\tWhat would you like \"To Do\"?");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine().toLowerCase();
			
			switch (input) {
				case "add":
					System.out.println("Choose a title");
					toDoTitle = sc.nextLine();
					System.out.println("Write a short description");
					toDoDescription = sc.nextLine();
					System.out.println("How many days should this take?");
					endDate = sc.nextLong();
					Task task = new Task(toDoTitle, toDoDescription, endDate);
					todo.addTask(task);
					sc.close();
					System.out.println("To Do added!");
					break;
				case "remove":
					System.out.println("Choose task to remove");
					toDoTitle = sc.nextLine();
					//todo.findTask(toDoTitle);
					System.out.println("Removing task");
					break;
				case "list":
					System.out.println("Listing all tasks");
					
					break;
				case "find":
					System.out.println("Looking for a specific task");
					
					break;
				case "edit":
					System.out.println("Editing the task");
					
					break;
				case "help":
					System.out.println("  -- This is the help section -- ");
					System.out.println(" +------------------------------+");
					System.out.println(" |\tCommand|Function\t\t|");
					System.out.println(" +------------------------------+");
					System.out.println(" |\tadd\tAdd a new Task\t|");
					System.out.println(" |\tremove\tRemove task\t|");
					System.out.println(" |\tlist\tList all tasks\t|");
					System.out.println(" |\tfind\tFind tasks\t|");
					System.out.println(" |\tedit\tEdit a task\t|");
					System.out.println(" |\texit\tExit program\t|");
					System.out.println(" +------------------------------+\n");
					break;
				case "exit":
					System.out.println("Exiting program");
					sc.close();
					running = false;
					break;
		
				default:
				break;
			}
		}
	}
}
