package pt.Dealership.Models.Cars;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import pt.Common.entities.GenericDTO;
import pt.Common.interfaces.IDTOable;
import pt.Dealership.Models.Vehicles.Colors.Color;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Models.Vehicles.Vehicle;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrand;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleCondition;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModel;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatus;
import pt.Dealership.Models.Vehicles.VehicleTypes.VehicleType;

@Entity
public class Car extends Vehicle implements IDTOable<Car> {
    @Min(2)
    private Integer seatCount;

    @Min(3)
    private Integer doorCount;

    public Car() {
    }

    public Car(VehicleType type, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int year, Color color, VehicleStatus status, VehicleCondition condition, double price, int seatCount, int doorCount) {
        super(type, brand, model, licensePlate, year, color, status, condition, price);
        this.seatCount = seatCount;
        this.doorCount = doorCount;
    }

    public Car(String vin, VehicleType type, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearAssembled, Color color, VehicleStatus status, VehicleCondition condition, double price, int seatCount, int doorCount) {
        super(vin, type, brand, model, licensePlate, yearAssembled, color, status, condition, price);
        this.seatCount = seatCount;
        this.doorCount = doorCount;
    }

    static final class Queries {
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM Car entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM Car entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
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
