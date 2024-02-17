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