package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Car extends RepresentationModel<Car> {
    @Id
    String serialNumber;

    @Column(nullable = false)
    long sellerId;
    long buyerId;

    long brandId;
    long modelId;
    long colorId;
    long conditionId;
    long carTypeId;

    int doorCount;
    String licensePlate;
    int kilometers;
    boolean isForSale;
}
