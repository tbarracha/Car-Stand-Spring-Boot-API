package pt.Dealership.Models.Vehicles;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import pt.Dealership.Models.Vehicles.Colors.Color;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrand;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleCondition;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModel;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatus;
import pt.Dealership.Models.Vehicles.VehicleTypes.VehicleType;

@MappedSuperclass
public abstract class Vehicle {
    @Id
    @Column(unique = true, nullable = false)
    protected String vin; // = VinGenerator.generateVin();

    @ManyToOne
    protected VehicleType type;

    @ManyToOne
    protected VehicleBrand brand;

    @ManyToOne
    protected VehicleModel model;

    @ManyToOne
    protected LicensePlate licensePlate;

    @Min(1990)
    @Max(2030)
    protected int yearAssembled;

    @ManyToOne
    protected Color color;

    @ManyToOne
    protected VehicleStatus status;

    @ManyToOne
    protected VehicleCondition condition;

    @DecimalMin(value = "0.99")
    protected double price;

    public Vehicle() {

    }

    public Vehicle(VehicleType type, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int year, Color color, VehicleStatus status, VehicleCondition condition, double price) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearAssembled = year;
        this.color = color;
        this.status = status;
        this.condition = condition;
        this.price = price;
    }

    public Vehicle(String vin, VehicleType type, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearAssembled, Color color, VehicleStatus status, VehicleCondition condition, double price) {
        this.vin = vin;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearAssembled = yearAssembled;
        this.color = color;
        this.status = status;
        this.condition = condition;
        this.price = price;
    }

    // Getters
    public String getVin() {
        return vin;
    }

    public VehicleType getType() {
        return type;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public VehicleModel getModel() {
        return model;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public int getYearAssembled() {
        return yearAssembled;
    }

    public Color getColor() {
        return color;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public VehicleCondition getCondition() {
        return condition;
    }

    public double getPrice() {
        return price;
    }


    // Setters

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setYearAssembled(int yearAssembled) {
        this.yearAssembled = yearAssembled;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public void setCondition(VehicleCondition condition) {
        this.condition = condition;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
