package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;

@Entity
public class LicensePlate extends VehicleStringContentEntity<LicensePlate> {

    public LicensePlate() {
        super();
    }

    public LicensePlate(String content) {
        super(content);
    }
}
