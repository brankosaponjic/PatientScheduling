package brankosaponjic.patientscheduling;

import brankosaponjic.patientscheduling.entities.Doctor;
import brankosaponjic.patientscheduling.repositories.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientschedulingApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

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

}
