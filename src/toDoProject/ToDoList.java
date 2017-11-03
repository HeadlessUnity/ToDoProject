package toDoProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ToDoList {
<<<<<<< HEAD
	Scanner sc;
=======
	
	Scanner sc = new Scanner(System.in);
>>>>>>> 1a4af59c821ce49bc97dee6fbb88c727ff04f378
	String input; 
	int inputIntValue;
	String inputStringValue;

	private ArrayList<Task> list = new ArrayList<Task>();

	public void addTask(Task task) {
		list.add(task);
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

<<<<<<< HEAD

	public void editTask(Task task, String choice) {
		
		if (choice.equalsIgnoreCase("name")) {
			task.setTitle(inputStringValue);			
		}
		else if(choice.equalsIgnoreCase("description")) {	
			task.setDescription(inputStringValue);
		}
		else if (choice.equalsIgnoreCase("date") ) {
			task.setEndDate(task.getEndDate().plusDays(inputIntValue));
		}
		else
			System.out.println(" -- Invalid command! --");
			

	}
=======
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
	
>>>>>>> 1a4af59c821ce49bc97dee6fbb88c727ff04f378
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
<<<<<<< HEAD
			}
		}
		return null;
	}
	
	public void inputString(String input) {
		this.inputStringValue = input;
	}
	
	public void inputInt(int input) {
		this.inputIntValue = input;
	}

=======
			}			
		}
		return null;
	}
>>>>>>> 1a4af59c821ce49bc97dee6fbb88c727ff04f378
}


