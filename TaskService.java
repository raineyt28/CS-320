package task_package;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TaskService {

    private final List<Task> taskList = new ArrayList<>();

    public boolean addTask(Task task) {
        String taskId = task.getTaskId();

        // Check if the task ID already exists in the taskList
        for (Task existingTask : taskList) {
            if (existingTask.getTaskId().equals(taskId)) {
                // ID already exists, return false (task not added)
                return false;
            }
        }

        // If the task ID is unique, add the task to the list
        taskList.add(task);
        return true; // Task added successfully
    }

    public Task newTask() {
        Task newTask = new Task(generateUniqueId());
        taskList.add(newTask);
        return newTask;
    }

    private String generateUniqueId() {
    	return UUID.randomUUID().toString();
	}

	Task findTaskById(String id) throws Exception {
        for (Task task : taskList) {
            if (id.equals(task.getTaskId())) {
                return task;
            }
        }
        throw new Exception("Does not exist!");
    } 
	public List<Task> getTaskList() { 
	
	
        return taskList; 
	}

	public void updateTaskName(String id, String name) throws Exception {
	    findTaskById(id).setName(name);
	}

	public void updateTaskDescription(String id, String description) throws Exception {
	    findTaskById(id).setDescription(description);
	}
}

