package brankosaponjic.patientscheduling;

import brankosaponjic.patientscheduling.entities.Appointment;
import brankosaponjic.patientscheduling.entities.Doctor;
import brankosaponjic.patientscheduling.entities.Insurance;
import brankosaponjic.patientscheduling.entities.Patient;
import brankosaponjic.patientscheduling.repositories.AppointmentRepository;
import brankosaponjic.patientscheduling.repositories.DoctorRepository;
import brankosaponjic.patientscheduling.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientschedulingApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    void testCreateDoctor() {
        Doctor doctor1 = new Doctor();
        doctor1.setFirstName("Branislav");
        doctor1.setLastName("Nestorović");
        doctor1.setSpeciality("Pulmonologist-Pediatrician");

        Doctor doctor2 = new Doctor();
        doctor2.setFirstName("Branislav");
        doctor2.setLastName("Tiodorović");
        doctor2.setSpeciality("Epidemiologist");

        Doctor doctor3 = new Doctor();
        doctor3.setFirstName("Goran");
        doctor3.setLastName("Stevanović");
        doctor3.setSpeciality("Infections");

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);
        doctorRepository.save(doctor3);
    }

    @Test
    void testCreatePatient() {
        // patient 1
        Patient patient1 = new Patient();
        patient1.setFirstName("Sinan");
        patient1.setLastName("Hasanović");
        patient1.setPhone("+38161084080");
        Insurance insurance1 = new Insurance();
        insurance1.setProviderName("Sava osiguranje");
        insurance1.setCopay(20d);
        patient1.setInsurance(insurance1);
        Optional<Doctor> doctor1 = doctorRepository.findById(3L);

        List<Doctor> doctors1 = Arrays.asList(doctor1.get());

        patient1.setDoctors(doctors1);

        // patient 2
        Patient patient2 = new Patient();
        patient2.setFirstName("Marko");
        patient2.setLastName("Marković");
        patient2.setPhone("+381603637548");

        Insurance insurance2 = new Insurance();
        insurance2.setProviderName("Generali osiguranje");
        insurance2.setCopay(10d);
        patient2.setInsurance(insurance2);

        Optional<Doctor> doctor2 = doctorRepository.findById(2L);

        List<Doctor> doctors2 = Arrays.asList(doctor2.get());

        patient2.setDoctors(doctors2);

        patientRepository.save(patient1);
        patientRepository.save(patient2);
    }

    @Test
    void testCreateAppointment() {
        Appointment appointment1 = new Appointment();
        Timestamp appointmentTime = new Timestamp(new Date().getTime());
        appointment1.setAppointmentTime(appointmentTime);
        appointment1.setReason("High temperature, and feel no smell, no taste!");
        appointment1.setStarted(true);
        appointment1.setPatient(patientRepository.findById(6L).get());
        appointment1.setDoctor(doctorRepository.findById(3L).get());

        appointmentRepository.save(appointment1);

    }

}
