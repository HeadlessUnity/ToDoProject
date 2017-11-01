package toDoProject;

import java.time.LocalDate;
import java.util.ArrayList;



public class ToDoList {
	private ArrayList<Task> list = new ArrayList<Task>();


	public void addTask(Task task) {

		list.add(task);
		task.setStartDate(LocalDate.now()); 

	}

	public void deleteTask(Task task) {

	}

	public void editTask(Task task) {

	}

	public Task findTask(String title) throws TaskNotFoundException{

		title =title.trim();

		for (Task task : list) {
			if (task.getTitle().equals(title)) {
return task;
			}
			
		}
		throw new TaskNotFoundException();

	}





}


