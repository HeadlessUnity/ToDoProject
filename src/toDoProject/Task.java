package toDoProject;

import java.time.LocalDate;


public class Task {
	private LocalDate startDate;
	private LocalDate endDate;
	private Status status;
	private String title;
	private String description;
	


	public Task(String title, String description, int numberOfDays) {
		this.title = title;
		this.description = description;
		startDate = LocalDate.now();
		endDate = startDate.plusDays(numberOfDays);
		status = Status.ACTIVE;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Title:\t" + title + "\n" +
				"Start:\t" + startDate + "\n" +
				"End:\t" + endDate + "\n" +
				"Status:\t" + status + "\n" +
				"Description: " + description + "\n";
	}
	
	

}
