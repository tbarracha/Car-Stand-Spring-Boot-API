package pt.Dealership.Models.Vehicles.VehicleBrands;

import jakarta.persistence.*;
import org.springframework.core.annotation.Order;
import pt.Common.entities.LongIdNamedEntity;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatus;
import pt.Dealership.Models.Vehicles.VehicleStringContentEntity;

@Order(1)
@Entity
public class VehicleBrand extends VehicleStringContentEntity<VehicleStatus> {
    public VehicleBrand() {
        super();
    }

    public VehicleBrand(String name) {
        super(name);
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }
}