package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import pt.carstand.Core.interfaces.IIdentifiable;
import pt.carstand.Core.interfaces.INameable;

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
