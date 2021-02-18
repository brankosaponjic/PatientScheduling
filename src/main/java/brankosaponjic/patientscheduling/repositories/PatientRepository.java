package brankosaponjic.patientscheduling.repositories;

import brankosaponjic.patientscheduling.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
