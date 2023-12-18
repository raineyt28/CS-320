package appointment;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

	@Test
	void testValidAppointmentCreation() {
		// Creating an appointment with valid details should not throw exceptions
		Date futureDate = new Date(System.currentTimeMillis() + 86400000); // Adding one day to the current date
		assertDoesNotThrow(() -> new Appointment("1234567890", futureDate, "Valid description"));
	}

	@Test
	void testInvalidAppointmentCreation() {
		// Creating an appointment with invalid details should throw
		// IllegalArgumentException

		// Invalid appointment ID
		assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Valid description"));
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("123456789012", new Date(), "Valid description"));

		// Appointment date in the past
		Date pastDate = new Date(0);
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1234567890", pastDate, "Valid description"));

		// Null description
		assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", new Date(), null));
		// Description exceeding 50 characters
		String tooLongDescription = "This description is too long for the appointment requirements.";
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1234567890", new Date(), tooLongDescription));
	}
}
