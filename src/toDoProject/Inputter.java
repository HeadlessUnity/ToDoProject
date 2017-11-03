package toDoProject;

import java.util.Scanner;

public class Inputter {
	
	
	private String toDoTitle;
	private String toDoDescription;
	private int endDate;
	private boolean running = true;
	
	public void startToDo() {
		
		// We start by creating the To do list
		ToDoList todo = new ToDoList();
		// print out some useful information
		System.out.println(startHint());
		
		
		// === TEMPORARY TASKS ===
		Task task1 = new Task("Test Task One", "vsdnoeivnsveaoinaidajsio", 10);
		todo.addTask(task1);
		Task task2 = new Task("Test Task Two", "fnsdvsodnvspivnsdposdvopsdpv", 20);
		todo.addTask(task2);
		Task task3 = new Task("Test Task Three", "cdsvndivsdnvisdnvsoi", 30);
		todo.addTask(task3);
		
		
		while (running) {
			
			
<<<<<<< HEAD
			try {
				System.out.println("Checking toDoList integrity...\n");
				Thread.sleep(2000);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			todo.checkExpDates();
=======
			System.out.println("Checking toDoList integrity...");
			todo.checkStatus();
>>>>>>> 1a4af59c821ce49bc97dee6fbb88c727ff04f378
			// Removes expired task(s) from toDoList. 
			todo.removeInactiveDates();
			// Asks the user what it want to do
			System.out.println("What would you like \"To Do\"?");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine().toLowerCase().trim();
			
			switch (input) {
			
				case "add":
					// Here we create a task, call the add function and put the task in the ToDoList
					// First we give it a title
					System.out.println("Choose a title");
					toDoTitle = sc.nextLine();
					// Then we give it a description
					System.out.println("Write a short description");
					toDoDescription = sc.nextLine();
					// Here we type how many days it should take
					System.out.println("How many days should this take?");
					endDate = sc.nextInt();
					// Create the task with all the previously added information
					Task task = new Task(toDoTitle, toDoDescription, endDate);
					// Adding the task to the List
					try {
						todo.addTask(task);
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("Task added!\n");
					System.out.println("-----------------------------\n");
				break;
					
				case "remove":
					System.out.println("Choose task to remove");
					toDoTitle = sc.nextLine();
					todo.removeTask(toDoTitle);
					try {
						System.out.println("Removing task...");
						Thread.sleep(1000);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					System.out.println("Task successfully removed!\n");
					System.out.println("-----------------------------\n");
				break;
					
				case "list":
					// Here we list all Tasks in the list
					System.out.println(" -- Listing all tasks -- \n");
					todo.printAll();
					System.out.println("-----------------------------\n");
				break;
					
				case "find":
					// Here we call the scanner to ask for a title to find.
					System.out.println("Type the title of Task");
					toDoTitle = sc.nextLine();
					try {
						System.out.println("Searching...\n");
						Thread.sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (todo.findTask(toDoTitle) != null)
						System.out.println("Found the task!\n" + todo.findTask(toDoTitle));
					else
						System.out.println(" -- Task not found! --");
					System.out.println("-----------------------------\n");
				break;
					
				case "edit":
					System.out.println("Enter task to edit ");
					try {
						toDoTitle = sc.nextLine();
						task = todo.findTask(toDoTitle);
						System.out.println("Found taskname: " + task.getTitle());
						System.out.println("What do you want to change? (name,description,date)");
						String choice = sc.nextLine();
						switch (choice) {
							case "name":
								System.out.println("Enter new Name:");
								toDoTitle = sc.nextLine();
								todo.inputString(toDoTitle);
								todo.editTask(task, choice);
							break;
							
							case "description":
								System.out.println("Enter new description:");
								toDoDescription = sc.nextLine();
								todo.inputString(toDoDescription);
								todo.editTask(task, choice);
							break;
							
							case "date":
								System.out.println("Enter number of days to set new enddate:");
								endDate = sc.nextInt();
								todo.inputInt(endDate);
								todo.editTask(task, choice);
							break;
	
						default:
							System.out.println("Invalid command");
							break;
						}
						
						System.out.println("Task changed!");
						System.out.println("-----------------------------\n");
					break;
					} catch (Exception e) {
						System.out.println(" -- Task not found --\n");
	//					e.printStackTrace();
						break;
					}
					
				case "help":
					// This is just some help if the user don't know what to type
					System.out.println(helpMessage());
				break;
					
				case "exit":
					// This just exits the program
					System.out.println("-- Exiting program --");
					sc.close();
					running = false;
				break;
		
				default:
				break;
			}
		}
	}
	
	public String startHint() {
		return " +-------------------------------------+\n" +
				" | Type \"help\" to see the command list |\n" +
				" |     Type \"exit\" to exit program     |\n" +
				" +-------------------------------------+\n";
	}
	
	public String helpMessage() {
		return "  -- This is the help section -- \n" + 
				" +--------------------------------------+\n" + 
				" |\t Command | Function\t\t|\n" +
				" +--------------------------------------+\n" + 
				" |\t-add\t   Add task\t\t|\n" +
				" |\t-remove\t   Remove task\t\t|\n" +
				" |\t-list\t   List all tasks\t|\n" +
				" |\t-find\t   Find tasks\t\t|\n" +
				" |\t-edit\t   Edit a task\t\t|\n" +
				" |\t-exit\t   Exit program\t\t|\n" +
				" +--------------------------------------+\n";
	}
}
