package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

@Entity
public class VehicleCondition extends VehicleStringContentEntity<VehicleCondition> {
    public VehicleCondition() {
        super();
    }

    public VehicleCondition(String name) {
        super(name);
    }
}