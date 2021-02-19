package brankosaponjic.patientscheduling;

import brankosaponjic.patientscheduling.entities.Doctor;
import brankosaponjic.patientscheduling.entities.Insurance;
import brankosaponjic.patientscheduling.entities.Patient;
import brankosaponjic.patientscheduling.repositories.DoctorRepository;
import brankosaponjic.patientscheduling.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientschedulingApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Test
    void testCreatePatient() {

        // patient 1
        Patient patient1 = new Patient();
        patient1.setFirstName("Petar");
        patient1.setLastName("Petrović");
        patient1.setPhone("+381662277448");

        Insurance insurance1 = new Insurance();
        insurance1.setProviderName("Dunav osiguranje");
        insurance1.setCopay(20d);
        patient1.setInsurance(insurance1);

        Optional<Doctor> doctor1 = doctorRepository.findById(1L);

        List<Doctor> doctors1 = Arrays.asList(doctor1.get());

        patient1.setDoctors(doctors1);

        // patient 2
        Patient patient2 = new Patient();
        patient2.setFirstName("Jovan");
        patient2.setLastName("Jovanović");
        patient2.setPhone("+381691137548");

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

}
