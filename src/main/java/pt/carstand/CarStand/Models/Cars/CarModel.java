package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class CarModel extends RepresentationModel<CarModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long brandId;

    @Column(unique = true)
    String name;

    public CarModel() {

    }

    public CarModel(long id, long brandId, String name) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
