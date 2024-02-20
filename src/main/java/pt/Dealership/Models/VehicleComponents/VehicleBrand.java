package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

@Entity
public class VehicleBrand extends VehicleStringContentEntity<VehicleStatus> {
    public VehicleBrand() {
        super();
    }

    public VehicleBrand(String name) {
        super(name);
    }
}