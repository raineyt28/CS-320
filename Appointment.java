package appointment;

import java.util.Calendar;
import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and at most 10 characters long.");
        }

        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);

        Calendar proposedDate = Calendar.getInstance();
        proposedDate.setTime(appointmentDate);

        if (proposedDate.before(now)) {
            throw new IllegalArgumentException("Appointment date must be in the future.");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters long.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters for Appointment fields

    public String getAppointmentId1() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

	public Object getAppointmentId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

