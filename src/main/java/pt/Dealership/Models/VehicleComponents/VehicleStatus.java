package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

@Entity
public class VehicleStatus extends VehicleStringContentEntity<VehicleStatus> {
    public VehicleStatus() {
        super();
    }

    public VehicleStatus(String name) {
        super(name);
    }
}