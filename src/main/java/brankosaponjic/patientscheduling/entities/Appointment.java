package brankosaponjic.patientscheduling.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private Long id;
    private Timestamp appointmentTime;
    private boolean started;
    private boolean ended;
    private String reason;
}
