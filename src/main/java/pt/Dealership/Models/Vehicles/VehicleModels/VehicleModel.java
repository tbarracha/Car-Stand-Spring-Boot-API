package pt.Dealership.Models.Vehicles.VehicleModels;

import jakarta.persistence.*;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrand;
import pt.Dealership.Models.Vehicles.VehicleStringContentEntity;

@Entity
public class VehicleModel extends VehicleStringContentEntity<VehicleModel> {

    @ManyToOne
    private VehicleBrand brand;

    public VehicleModel() {
        super();
    }

    public VehicleModel(VehicleBrand brand, String name) {
        super(name);
        this.brand = brand;
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
        public static final String FIND_WITH_BRAND_ID = "SELECT entity FROM VehicleModel entity WHERE entity.brand.id = :brandId";
        public static final String FIND_WITH_BRAND_NAME = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.brand.name) = LOWER(:brandName)";
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }
}