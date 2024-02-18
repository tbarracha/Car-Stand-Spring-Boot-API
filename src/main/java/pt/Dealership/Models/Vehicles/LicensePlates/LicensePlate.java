package pt.Dealership.Models.Vehicles.LicensePlates;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class LicensePlate extends EntityBase<LicensePlate> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public LicensePlate() {
    }

    public LicensePlate(String name) {
        this.name = name;
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM LicensePlate entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleCondition entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM LicensePlate entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
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
