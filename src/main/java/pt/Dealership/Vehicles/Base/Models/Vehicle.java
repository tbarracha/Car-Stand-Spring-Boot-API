package pt.Dealership.Vehicles.Base.Models;

import org.springframework.hateoas.RepresentationModel;

public abstract class Vehicle extends RepresentationModel<Vehicle> {
    private VehicleType vehicleType;

    private int year;

    public Vehicle() {

    }

    public Vehicle(VehicleType vehicleType, int year) {
        this.vehicleType = vehicleType;
        this.year = year;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getYear() {
        return year;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
