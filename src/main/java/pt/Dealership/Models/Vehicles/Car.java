package pt.Dealership.Models.Vehicles;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import pt.Common.entities.GenericDTO;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;

@Entity
public class Car extends Vehicle<Car> {
    @Min(2)
    private Integer seatCount;

    @Min(3)
    private Integer doorCount;

    public Car() {
    }

    public Car(VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price, int seatCount, int doorCount) {
        super(type, status, condition, color, brand, model, licensePlate, yearOfAssembly, price);
        this.seatCount = seatCount;
        this.doorCount = doorCount;
    }

    public Car(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price, int seatCount, int doorCount) {
        super(vin, type, status, condition, color, brand, model, licensePlate, yearOfAssembly, price);
        this.seatCount = seatCount;
        this.doorCount = doorCount;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public Integer getDoorCount() {
        return doorCount;
    }


    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    @Override
    public GenericDTO<Car> toDTO() {
        return new GenericDTO<>(this);
    }
}
