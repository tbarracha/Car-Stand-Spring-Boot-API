package pt.Dealership.Models.Vehicles;

import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;

public class CarDTO extends VehicleDTO<Car> {
    private Integer seatCount;

    private Integer doorCount;

    public CarDTO(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, Integer releaseYear, int seatCount, int doorCount) {
        super(vin, type, status, condition, color, brand, model, licensePlate, releaseYear);
        this.seatCount = seatCount;
        this.doorCount = doorCount;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
    }
}
