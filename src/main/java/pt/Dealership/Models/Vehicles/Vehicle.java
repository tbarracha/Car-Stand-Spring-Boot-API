package pt.Dealership.Models.Vehicles;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import pt.Dealership.Enums.DefaultVehicleStatus;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;


@MappedSuperclass
public abstract class Vehicle<T> {
    @Id
    @Column(unique = true, nullable = false)
    protected String vin;

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

    @Min(1990)
    @Max(2024)
    protected Integer releaseYear; // can't be "year" because it is a reserved variable name

    protected String creationDate;
    protected String purchaseDate;

    @DecimalMin(value = "0.99")
    protected Double sellPrice;

    @DecimalMin(value = "0.99")
    protected Double buyingPrice;

    protected String buyerId;

    protected String sellerId;

    @Column(unique = true)
    protected String transactionId;

    public Vehicle() {

    }

    public Vehicle(VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price) {
        this.type = type;
        this.status = status;
        this.condition = condition;
        this.color = color;
        this.model = model;
        this.licensePlate = licensePlate;
        this.releaseYear = yearOfAssembly;
        this.sellPrice = price;
    }

    public Vehicle(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price) {
        this.vin = vin;
        this.type = type;
        this.status = status;
        this.condition = condition;
        this.color = color;
        this.model = model;
        this.licensePlate = licensePlate;
        this.releaseYear = yearOfAssembly;
        this.sellPrice = price;
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
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }


    // Selling Price
    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }


    // Buying Price
    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }


    // Buyer ID
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }


    // Seller ID
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    // transaction
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }


    // Creation Date
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }


    // Purcahse Date
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // Delete
    public void delete() {
        this.status = null;
    }

    public void restore() {
        this.status = new VehicleStatus(DefaultVehicleStatus.UNAVAILABLE.toString());
    }
}
