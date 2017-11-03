package toDoProject;

import java.util.ArrayList;
import java.util.Iterator;

public class ToDoList {
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
		Task task = findTask(title);
		if (task == null)
			System.out.println(" -- Task not found! --\n" + "Returning to start...");
		else {
			list.remove(task);
			try {
				System.out.println("Removing task...");
				Thread.sleep(1000);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("Task successfully removed!\n");
		}
	}

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
	
	public void inputString(String input) {
		this.inputStringValue = input;
	}
	
	public void inputInt(int input) {
		this.inputIntValue = input;
	}

}


