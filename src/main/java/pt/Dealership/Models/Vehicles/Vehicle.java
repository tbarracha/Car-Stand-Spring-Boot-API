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
    protected Integer yearOfAssembly; // can't be "year" because it is a reserved variable name

    @ManyToOne
    protected Color color;

    @ManyToOne
    protected VehicleStatus status;

    @ManyToOne
    protected VehicleCondition condition;

    @DecimalMin(value = "0.99")
    protected Double price;

    public Vehicle() {

    }

    public Vehicle(VehicleType type, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int year, Color color, VehicleStatus status, VehicleCondition condition, double price) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearOfAssembly = year;
        this.color = color;
        this.status = status;
        this.condition = condition;
        this.price = price;
    }

    public Vehicle(String vin, VehicleType type, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, Color color, VehicleStatus status, VehicleCondition condition, double price) {
        this.vin = vin;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.yearOfAssembly = yearOfAssembly;
        this.color = color;
        this.status = status;
        this.condition = condition;
        this.price = price;
    }

    static final class Queries {
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM Car entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM Car entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
        // find by licensePlate
        // find by brandId
        // find by brandName
        // find by modelId
        // find by modelName
        // find by seatCount
        // find by doorCount
        // find by colorId
        // find by colorHexadecimal
        // find by yearOfAssembly
        // find by status
        // find by condition
        // find by price (price is equals or lower)
        // find by price range (min, max)
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

    public Integer getYearOfAssembly() {
        return yearOfAssembly;
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

    public Double getPrice() {
        return price;
    }


    // Setters
    public void setVin(String vin) {
        this.vin = vin;
    }

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

    public void setYearOfAssembly(int yearOfAssembly) {
        this.yearOfAssembly = yearOfAssembly;
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
