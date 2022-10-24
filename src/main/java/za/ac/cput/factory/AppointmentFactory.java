package za.ac.cput.factory;

import za.ac.cput.domain.Appointment;
import za.ac.cput.util.StringHelper;

//Sinazo Mehlomakhulu(216076498)

public class AppointmentFactory {
    public static Appointment createAppointment(String appointmentId, String appointmentDate, String appointmentDuration, String appointmentTime) {
        StringHelper.checkStringParam("appointmentId", appointmentId);
        return new Appointment.Builder().appointmentId(appointmentId).appointmentDate(appointmentDate).appointmentDuration(appointmentDuration).appointmentTime(appointmentTime).build();
    }
}
