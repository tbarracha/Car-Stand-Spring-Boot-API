package pt.Dealership.Models.Vehicles;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import pt.Common.interfaces.IDTOable;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;

@MappedSuperclass
public abstract class Vehicle<T> implements IDTOable<T> {
    @Id
    @Column(unique = true, nullable = false)
    protected String vin; // = VinGenerator.generateVin();

    @ManyToOne
    protected VehicleType type;

    @ManyToOne
    protected VehicleStatus status;

    @ManyToOne
    protected VehicleCondition condition;

    @ManyToOne
    protected Color color;

    @ManyToOne
    protected VehicleBrand brand;

    @ManyToOne
    protected VehicleModel model;

    @ManyToOne
    protected LicensePlate licensePlate;

    // add endpoints
    String buyerID;
    String transactionID;

    @Min(1990)
    @Max(2030)
    protected Integer yearOfAssembly; // can't be "year" because it is a reserved variable name

    @DecimalMin(value = "0.99")
    protected Double price;

    public Vehicle() {

    }

    public Vehicle(VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price) {
        this.type = type;
        this.status = status;
        this.condition = condition;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearOfAssembly = yearOfAssembly;
        this.price = price;
    }

    public Vehicle(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price) {
        this.vin = vin;
        this.type = type;
        this.status = status;
        this.condition = condition;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearOfAssembly = yearOfAssembly;
        this.price = price;
    }

    // Getters and Setters
    // VIN
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    // Type
    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    // Status
    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    // Condition
    public VehicleCondition getCondition() {
        return condition;
    }

    public void setCondition(VehicleCondition condition) {
        this.condition = condition;
    }

    // Color
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // Brand
    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    // Model
    public VehicleModel getModel() {
        return model;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    // License Plate
    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    // Year of Assembly
    public Integer getYearOfAssembly() {
        return yearOfAssembly;
    }

    public void setYearOfAssembly(Integer yearOfAssembly) {
        this.yearOfAssembly = yearOfAssembly;
    }

    // Price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
