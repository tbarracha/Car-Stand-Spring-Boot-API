package pt.Dealership.Vehicles.Base.Models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.base.interfaces.IIdentifiable;
import pt.Dealership.base.interfaces.INameable;

@Entity
public class VehicleType extends RepresentationModel<VehicleType> implements IIdentifiable<Long>, INameable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String name;

    public VehicleType() {

    }

    public VehicleType(String vehicleType) {
        this.name = vehicleType;
    }

    @Override
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
