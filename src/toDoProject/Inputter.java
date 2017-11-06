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


			System.out.println("Checking toDoList integrity...");
			todo.checkStatus();
			// Removes expired task(s) from toDoList. 
			todo.removeExpDates();
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
				todo.addTask(task);
				System.out.println("To Do added!\n");
				break;

			case "remove":
				System.out.println("Choose task to remove");
				toDoTitle = sc.nextLine();
				todo.removeTask(toDoTitle);
				System.out.println("Removing task\n");
				break;

			case "list":
				// Here we list all Tasks in the list
				System.out.println(" -- Listing all tasks -- ");
				todo.printAll();
				System.out.println("-----------------------------\n");
				break;

			case "find":
				// Here we call the scanner to ask for a title to find.
				System.out.println("Type the title of Task");
				toDoTitle = sc.nextLine();
				System.out.println(todo.findTask(toDoTitle));
				System.out.println("Congratulations! you found the task!\n");
				break;

			case "edit":
				todo.editTask();
				System.out.println("Editing the task\n");
				break;

			case "help":
				// This is just some help if the user don't know what to type
				System.out.println(helpMessage());
				break;

			case "sort":
				todo.sortTodoByEndDateList();
				break;

			case "exit":
				// This just exits the program
				System.out.println("Exiting program");
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
