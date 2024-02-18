package pt.Dealership.Models.Vehicles.VehicleTypes;

import jakarta.persistence.*;
import pt.Dealership.Models.Vehicles.VehicleStringContentEntity;

@Entity
public class VehicleType extends VehicleStringContentEntity<VehicleType> {
    public VehicleType() {
        super();
    }

    public VehicleType(String name) {
        super(name);
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }
}