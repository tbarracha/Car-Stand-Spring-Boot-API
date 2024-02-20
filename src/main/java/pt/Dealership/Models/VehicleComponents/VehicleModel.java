package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;

@Entity
public class VehicleModel extends VehicleStringContentEntity<VehicleModel> {

    @ManyToOne
    private VehicleBrand brand;

    public VehicleModel() {
        super();
    }

    public VehicleModel(VehicleBrand brand, String name) {
        super(name);
        this.brand = brand;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }
}