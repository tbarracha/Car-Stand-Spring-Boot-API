package pt.Dealership.Models.Vehicles.LicensePlates;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;
import pt.Common.entities.LongIdNamedEntity;
import pt.Dealership.Models.Vehicles.VehicleStringContentEntity;

@Entity
public class LicensePlate extends VehicleStringContentEntity<LicensePlate> {

    public LicensePlate() {
        super();
    }

    public LicensePlate(String content) {
        super(content);
    }

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM LicensePlate entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM LicensePlate entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM LicensePlate entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }
}
