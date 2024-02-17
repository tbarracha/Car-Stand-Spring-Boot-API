package pt.Dealership.Vehicles.VehicleBrands;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class VehicleBrand extends EntityBase<VehicleBrand> {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public VehicleBrand() {
    }

    public VehicleBrand(String name) {
        this.name = name;
    }

    public class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_BY_FIRST_LETTER = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}