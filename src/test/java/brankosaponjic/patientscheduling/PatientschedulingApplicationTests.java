package brankosaponjic.patientscheduling;

import brankosaponjic.patientscheduling.entities.Appointment;
import brankosaponjic.patientscheduling.repositories.AppointmentRepository;
import brankosaponjic.patientscheduling.repositories.DoctorRepository;
import brankosaponjic.patientscheduling.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class PatientschedulingApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    void testCreateAppointment() {
        Appointment appointment1 = new Appointment();
        Timestamp appointmentTime = new Timestamp(new Date().getTime());
        appointment1.setAppointmentTime(appointmentTime);
        appointment1.setReason("I have lung inflammation");
        appointment1.setStarted(true);
        appointment1.setPatient(patientRepository.findById(4L).get());
        appointment1.setDoctor(doctorRepository.findById(1L).get());

        appointmentRepository.save(appointment1);

    }

}
