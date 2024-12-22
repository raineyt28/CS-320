package task_package;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NewTaskService {

	private final Map<String, Task> taskMap = new HashMap<>();

    public boolean addTask(Task task) {
        String taskId = task.getTaskId();

        // Check if the task ID already exists in taskMap
        if (taskMap.containsKey(taskId)) {
            // ID already exists, return false (task not added)
            return false;
        }

        // If the task ID is unique, add the task to the map
        taskMap.put(taskId, task);
        return true; // Task added successfully
    }

    public Task newTask() {
        String uniqueId = generateUniqueId();
        Task newTask = new Task(uniqueId);
        taskMap.put(uniqueId, newTask);
        return newTask;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    Task findTaskById(String id) throws Exception {
        if (taskMap.containsKey(id)) {
            return taskMap.get(id);
        }
        throw new Exception("Task does not exist!");
    }

    public Collection<Task> getTaskList() {
        return taskMap.values();
    }

    public void updateTaskName(String id, String name) throws Exception {
        findTaskById(id).setName(name);
    }

    public void updateTaskDescription(String id, String description) throws Exception {
        findTaskById(id).setDescription(description);
    }
}
	
	

