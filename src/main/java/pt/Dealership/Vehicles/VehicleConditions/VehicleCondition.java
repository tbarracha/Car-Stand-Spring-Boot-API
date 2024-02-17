package pt.Dealership.Vehicles.VehicleConditions;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class VehicleCondition extends EntityBase<VehicleCondition> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public VehicleCondition() {
    }

    public VehicleCondition(String name) {
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

/*
package pt.Dealership.Vehicles.VehicleTypes;

import jakarta.persistence.*;
import pt.Dealership.Models.NamedEntity;

@Entity
public class VehicleType extends NamedEntity<VehicleType> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public VehicleType() {
    }

    public VehicleType(String name) {
        super(name);
    }
}
*/