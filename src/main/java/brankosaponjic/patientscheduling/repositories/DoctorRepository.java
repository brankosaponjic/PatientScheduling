package brankosaponjic.patientscheduling.repositories;

import brankosaponjic.patientscheduling.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
