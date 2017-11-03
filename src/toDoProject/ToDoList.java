package toDoProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class ToDoList {
	Scanner sc;
	String input; 
	int inputIntValue;
	String inputStringValue;

	private ArrayList<Task> list = new ArrayList<Task>();


	public void addTask(Task task) {
		list.add(task);
	}
	
	public void checkExpDates() {
		Iterator<Task> it = list.iterator(); 
		while (it.hasNext()) {
			Task task = it.next();
			if (task.getEndDate().isBefore(task.getStartDate())){
				System.out.println("USER_NOTICE: Found expired task: " + task.getTitle() +"\nChanging task: " + task.getTitle() + " to EXPIRED.");
				task.setStatus(Status.EXPIRED);
				
			}
		}
	}


	public void removeInactiveDates() {
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
		System.out.println(list.indexOf(findTask(title)));
		list.remove(findTask(title));
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
	
	public void inputString(String input) {
		this.inputStringValue = input;
	}
	
	public void inputInt(int input) {
		this.inputIntValue = input;
	}

}


