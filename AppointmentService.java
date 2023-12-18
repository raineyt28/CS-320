package appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.NoSuchElementException;

public class AppointmentService {
    private final List<Appointment> appointmentList = new ArrayList<>();

    public void newAppointment(Date date, String description) {
        String uniqueId = generateUniqueAppointmentId();
        Appointment appt = new Appointment(uniqueId, date, description);
        appointmentList.add(appt);
    }

    public void newAppointment(Date date) {
        String uniqueId = generateUniqueAppointmentId();
        Appointment appt = new Appointment(uniqueId, date, uniqueId); // Using uniqueId as description for demonstration
        appointmentList.add(appt);
    }

    public void deleteAppointment(String id) throws NoSuchElementException {
        Appointment appointment = searchForAppointment(id);
        appointmentList.remove(appointment);
    }

    protected List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    private String generateUniqueAppointmentId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private Appointment searchForAppointment(String id) throws NoSuchElementException {
        return appointmentList.stream()
                .filter(appt -> id.equals(appt.getAppointmentId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Appointment not found"));
    }
}

