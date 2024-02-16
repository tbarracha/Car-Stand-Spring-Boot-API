package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class CarType extends RepresentationModel<CarType> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String carType;

    public CarType() {

    }

    public CarType(long id, String carType) {
        this.id = id;
        this.carType = carType;
    }

    public long getId() {
        return id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
