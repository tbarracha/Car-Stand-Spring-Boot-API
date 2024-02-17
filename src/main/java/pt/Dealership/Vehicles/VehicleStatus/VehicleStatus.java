package pt.Dealership.Vehicles.VehicleStatus;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class VehicleStatus extends EntityBase<VehicleStatus> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public VehicleStatus() {
    }

    public VehicleStatus(String name) {
        this.name = name;
    }

    // static class used for repository search queries
    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
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