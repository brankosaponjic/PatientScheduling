package brankosaponjic.patientscheduling.repositories;

import brankosaponjic.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
