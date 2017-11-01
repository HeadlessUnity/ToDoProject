package toDoProject;

import java.time.LocalDate;
import java.util.ArrayList;



public class ToDoList {
	private ArrayList<Task> list = new ArrayList<Task>();


	public void addTask(Task task) {

		list.add(task);

	}

	public void deleteTask(Task task) {

	}

	public void editTask(Task task) {

	}

	public void findTask(String title){

		title =title.trim();

		for (Task task : list) {
			if (task.getTitle().equals(title)) {
				System.out.println(task.toString());
			}
			
		}
		

	}





}


