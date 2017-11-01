package toDoProject;

import java.time.LocalDate;
import java.util.ArrayList;



public class ToDoList {


	private ArrayList<Task> list = new ArrayList<Task>();


	public void addTask(Task task) {

		list.add(task);

	}

	public void deleteTask(Task task) {
		list.remove(task);

	}

	public void editTask(String name) {
		try {
			findTask(name);
			System.out.println(name.toString());

		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void printAll() {
		for(Task l : list)
			System.out.println(l.toString());
	}





	public void findTask(String title){


		title =title.trim();

		for (Task task : list) {
			if (task.getTitle().equals(title)) {
				System.out.println(task.toString());
			}
			else {
				System.out.println("Task not Found");

			}

		}



	}

}


