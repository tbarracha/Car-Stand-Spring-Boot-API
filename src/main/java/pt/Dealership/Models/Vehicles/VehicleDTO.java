package pt.Dealership.Models.Vehicles;

import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;

public abstract class VehicleDTO<T extends Vehicle<T>> extends RepresentationModel<VehicleDTO<T>> {
    protected String vin;

    protected VehicleType type;

    protected VehicleStatus status;

    protected VehicleCondition condition;

    protected Color color;

    protected VehicleBrand brand;

    protected VehicleModel model;

    protected LicensePlate licensePlate;

    protected Integer releaseYear;

    public VehicleDTO(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, Integer releaseYear) {
        this.vin = vin;
        this.type = type;
        this.status = status;
        this.condition = condition;
        this.color = color;
        this.brand = brand;
        this.model = model;

        if (this.brand == null)
            this.brand = this.model.getBrand();

        this.licensePlate = licensePlate;
        this.releaseYear = releaseYear;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public VehicleCondition getCondition() {
        return condition;
    }

    public void setCondition(VehicleCondition condition) {
        this.condition = condition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }

    public VehicleModel getModel() {
        return model;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
