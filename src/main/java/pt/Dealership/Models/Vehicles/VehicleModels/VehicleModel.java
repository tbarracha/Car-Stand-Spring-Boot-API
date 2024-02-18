package pt.Dealership.Models.Vehicles.VehicleModels;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrand;

@Entity
public class VehicleModel extends EntityBase<VehicleModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private VehicleBrand brand;

    public VehicleModel() {
    }

    public VehicleModel(VehicleBrand brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
        public static final String FIND_WITH_BRAND_ID = "SELECT entity FROM VehicleModel entity WHERE entity.brand.id = :brandId";
        public static final String FIND_WITH_BRAND_NAME = "SELECT entity FROM VehicleModel entity WHERE LOWER(entity.brand.name) = LOWER(:brandName)";
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleBrand getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(VehicleBrand brand) {
        this.brand = brand;
    }
}