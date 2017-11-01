package toDoProject;

import java.util.ArrayList;

public class ToDoList {
	private ArrayList<String> list;
	
	
	
	
	
	
	public void addTask(String title, String description) {
		
		//TODO: Add fucking check time date.
		Task task1 = new Task(Status.ACTIVE, title, description);
		//tasklist<String>.add(task1);
	}
	
	public void deleteTask(Task task) {
		
	}
	
	public void editTask(Task task) {
		
	}

	public void findTask(Task task) {
		
	}
	
}
