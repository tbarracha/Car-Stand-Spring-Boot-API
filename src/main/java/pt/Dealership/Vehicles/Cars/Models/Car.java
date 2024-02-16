package pt.Dealership.Vehicles.Cars.Models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.Users.AppUsers.Buyer;
import pt.Dealership.Users.AppUsers.Seller;

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
