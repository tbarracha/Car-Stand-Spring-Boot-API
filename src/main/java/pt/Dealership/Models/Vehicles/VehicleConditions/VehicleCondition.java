package pt.Dealership.Models.Vehicles.VehicleConditions;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;
import pt.Dealership.Models.Vehicles.VehicleStringContentEntity;

@Order(3)
@Entity
public class VehicleCondition extends VehicleStringContentEntity<VehicleCondition> {
    public VehicleCondition() {
        super();
    }

    public VehicleCondition(String name) {
        super(name);
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleCondition entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleCondition entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleCondition entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }
}