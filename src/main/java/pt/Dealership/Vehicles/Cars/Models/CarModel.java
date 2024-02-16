package pt.Dealership.Vehicles.Cars.Models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class CarModel extends RepresentationModel<CarModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne
    CarBrand brand;

    @Column(unique = true)
    String name;

    public CarModel() {

    }

    public CarModel(CarBrand brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }
}
