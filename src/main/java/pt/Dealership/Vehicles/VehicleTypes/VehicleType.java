package pt.Dealership.Vehicles.VehicleTypes;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class VehicleType extends EntityBase<VehicleType> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String type;

    public VehicleType() {
    }

    public VehicleType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
