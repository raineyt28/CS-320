package task_package;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private String name, description;

    @BeforeEach
    void setUp() {
        name = "ShortName";
        description = "Task Description";
    }

    @Test
    void newTaskTest() {
        TaskService service = new TaskService();
        Task newTask = new Task("TestTaskId", "TestName", "TestDescription");
        assertTrue(service.addTask(newTask));
        assertEquals(1, service.getTaskList().size());
        assertEquals("TestTaskId", service.getTaskList().get(0).getTaskId());
        assertEquals("TestName", service.getTaskList().get(0).getName());
        assertEquals("TestDescription", service.getTaskList().get(0).getDescription());
    }

    @Test
    void deleteTaskTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertEquals(1, service.getTaskList().size());
        service.findTaskById(service.getTaskList().get(0).getTaskId());
        assertEquals(0, service.getTaskList().size());
    }

    @Test
    void updateNameTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        service.updateTaskName(service.getTaskList().get(0).getTaskId(), name);
        assertEquals(name, service.getTaskList().get(0).getName());
    }

    @Test
    void updateDescriptionTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        service.updateTaskDescription(service.getTaskList().get(0).getTaskId(), description);
        assertEquals(description, service.getTaskList().get(0).getDescription());
    }

    @RepeatedTest(4)
    void UuidTest() {
        TaskService service = new TaskService();
        service.newTask();
        service.newTask();
        service.newTask();
        assertEquals(3, service.getTaskList().size());
        assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(1).getTaskId());
        assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(2).getTaskId());
        assertNotEquals(service.getTaskList().get(1).getTaskId(), service.getTaskList().get(2).getTaskId());
    }
}

