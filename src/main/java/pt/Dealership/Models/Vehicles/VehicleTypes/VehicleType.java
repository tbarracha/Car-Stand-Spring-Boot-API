package pt.Dealership.Models.Vehicles.VehicleTypes;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class VehicleType extends EntityBase<VehicleType> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public VehicleType() {
    }

    public VehicleType(String name) {
        this.name = name;
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
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