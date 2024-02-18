package pt.Dealership.Models.Vehicles.VehicleStatus;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;
import pt.Dealership.Models.Vehicles.VehicleStringContentEntity;

@Order(4)
@Entity
public class VehicleStatus extends VehicleStringContentEntity<VehicleStatus> {
    public VehicleStatus() {
        super();
    }

    public VehicleStatus(String name) {
        super(name);
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }
}