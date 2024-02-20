package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;

@Entity
public class VehicleType extends VehicleStringContentEntity<VehicleType> {
    public VehicleType() {
        super();
    }

    public VehicleType(String name) {
        super(name);
    }
}