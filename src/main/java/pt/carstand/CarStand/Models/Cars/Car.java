package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import pt.carstand.CarStand.Models.AppUsers.Buyer;
import pt.carstand.CarStand.Models.AppUsers.Seller;

@Entity
public class Car extends RepresentationModel<Car> {

    // Users
    @OneToOne
    Seller seller;

    @OneToOne
    Buyer buyer;


    // Properties
    @Id
    String serialNumber;

    @OneToOne
    CarBrand brand;

    @OneToOne
    CarModel model;

    @OneToOne
    LicensePlate licensePlate;

    @OneToOne
    Color color;

    @OneToOne
    CarCondition condition;

    @OneToOne
    CarType type;

    @Column(nullable = false)
    int doorCount;

    int kilometers;
    boolean isForSale;
}
