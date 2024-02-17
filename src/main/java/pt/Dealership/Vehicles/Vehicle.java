package pt.Dealership.Vehicles;


import pt.Dealership.Vehicles.Colors.Color;
import pt.Dealership.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Vehicles.VehicleBrands.VehicleBrand;
import pt.Dealership.Vehicles.VehicleConditions.VehicleCondition;
import pt.Dealership.Vehicles.VehicleModels.VehicleModel;
import pt.Dealership.Vehicles.VehicleStatus.VehicleStatus;
import pt.Dealership.Vehicles.VehicleTypes.VehicleType;

public abstract class Vehicle {
    private VehicleType type;
    private VehicleBrand brand;
    private VehicleModel model;
    private LicensePlate licensePlate;
    private int year;
    private Color color;
    private VehicleStatus status;
    private VehicleCondition condition;
}
