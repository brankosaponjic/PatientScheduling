package brankosaponjic.patientscheduling.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    private String providerName;
    private double copay;
}
