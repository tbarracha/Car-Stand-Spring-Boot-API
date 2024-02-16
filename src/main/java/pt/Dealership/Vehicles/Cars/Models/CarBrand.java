package pt.Dealership.Vehicles.Cars.Models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.base.interfaces.IIdentifiable;
import pt.Dealership.base.interfaces.INameable;

@Entity
public class CarBrand extends RepresentationModel<CarBrand> implements IIdentifiable<Long>, INameable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, unique = true)
    String name;

    public CarBrand() {

    }

    public CarBrand(String name) {
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
