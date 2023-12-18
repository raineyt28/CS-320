package task_package;

public class Task {

	private String taskId;
	private String name;
	private String description;

	Task() {
		initializeDefaults();
	}

	Task(String taskId) {
		validateTaskId(taskId);
		initializeDefaults();
	}

	Task(String taskId, String name) {
		validateTaskId(taskId);
		setName(name);
		initializeDefaults();
	}

	Task(String taskId, String name, String desc) {
		validateTaskId(taskId);
		setName(name);
		setDescription(desc);
	}

	public final String getTaskId() {
		return taskId;
	}

	public final String getName() {
		return name;
	}

	protected void setName(String name) {
	    if (name == null) {
	        throw new IllegalArgumentException("Invalid task name. Please ensure it is not null.");
	    }
	    if (name.length() > 20) {
	        throw new IllegalArgumentException("Invalid task name length. Please ensure it is shorter than 20 characters.");
	    }
	    this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	protected void setDescription(String taskDescription) {
	    if (taskDescription == null) {
	        throw new IllegalArgumentException("Invalid task description. Please ensure it is not null.");
	    }
	    if (taskDescription.length() > 50) {
	        throw new IllegalArgumentException("Invalid task description length. Please ensure it is shorter than 50 characters.");
	    }
	    this.description = taskDescription;
	}

	private void validateTaskId(String taskId) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException(
					"Invalid task ID. Please ensure it is not null and does not exceed 10 characters.");
		} else {
			this.taskId = taskId;
		}
	}

	private void initializeDefaults() {
		this.taskId = "INITIAL";
		this.name = "INITIAL";
		this.description = "INITIAL DESCRIPTION";
	}
}
