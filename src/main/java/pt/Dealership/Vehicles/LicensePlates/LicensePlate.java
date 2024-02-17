package pt.Dealership.Vehicles.LicensePlates;

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
