package task_package;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {

    private String validId, validName, validDescription;
    private String tooLongId, tooLongName, tooLongDescription;

    @BeforeEach
    void setUp() {
        validId = "NewID1234";
        validName = "ShortName";
        validDescription = "Task Description";
        tooLongId = "1234567890";
        tooLongName = "This is a longer name, too long infact";
        tooLongDescription = "This description exceeds fifty characters. It's too long.";
    }

    @Test
    void getTaskIdTest() {
        Task task = new Task(validId);
        Assertions.assertEquals(validId, task.getTaskId());
    }

    @Test
    void getNameTest() {
        Task task = new Task(validId, validName);
        Assertions.assertEquals(validName, task.getName());
    }

    @Test
    void getDescriptionTest() {
        Task task = new Task(validId, validName, validDescription);
        Assertions.assertEquals(validDescription, task.getDescription());
    }

    @Test
    void setNameTest() {
        Task task = new Task();
        task.setName(validName);
        Assertions.assertEquals(validName, task.getName());
    }

    @Test
    void setDescriptionTest() {
        Task task = new Task();
        task.setDescription(validDescription);
        Assertions.assertEquals(validDescription, task.getDescription());
    }

    @Test
    void TaskIdTooLongTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(tooLongId));
    }

    @Test
    void setTooLongNameTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(tooLongName));
    }

    @Test
    void setTooLongDescriptionTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription(tooLongDescription));
    }

    @Test
    void TaskIdNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
    }

    @Test
    void TaskNameNullTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    void TaskDescriptionNullTest() {
        Task task = new Task();
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }
}


