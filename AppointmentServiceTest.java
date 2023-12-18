package appointment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private String id, description, tooLongDescription;
    private Date date, pastDate;

    @BeforeEach
    void setUp() {
        id = "1234567890";
        description = "The appt object shall have a required description.";
        date = new Date(3021 - 1900, Calendar.JANUARY, 1);
        tooLongDescription = "This description is too long for the appointment requirements but good for testing.";
        pastDate = new Date(0);
    }

    @Test
    void testNewAppointment() {
        AppointmentService service = new AppointmentService();

        service.newAppointment(date, description);
        assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
        assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
        assertNull(service.getAppointmentList().get(0).getDescription());

        service.newAppointment(date);
        assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
        assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
        assertNull(service.getAppointmentList().get(1).getDescription());

        service.newAppointment(date, description);
        assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
        assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
        assertEquals(description, service.getAppointmentList().get(2).getDescription());

        assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
                service.getAppointmentList().get(1).getAppointmentId());
        assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
                service.getAppointmentList().get(2).getAppointmentId());
        assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
                service.getAppointmentList().get(2).getAppointmentId());

        assertThrows(IllegalArgumentException.class, () -> service.newAppointment(pastDate));
        assertThrows(IllegalArgumentException.class, () -> service.newAppointment(date, tooLongDescription));
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();

        service.newAppointment(date, description);
        service.newAppointment(date, description);
        service.newAppointment(date, description);

        String firstId = (String) service.getAppointmentList().get(0).getAppointmentId();

        assertThrows(NoSuchElementException.class, () -> service.deleteAppointment(id));
        assertThrows(NoSuchElementException.class, () -> service.deleteAppointment("invalid_id"));

        assertDoesNotThrow(() -> service.deleteAppointment(firstId));
        assertThrows(NoSuchElementException.class, () -> service.deleteAppointment(firstId));
    }
}



