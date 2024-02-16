package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class CarCondition extends RepresentationModel<CarCondition> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String condition;

    public CarCondition(long id, String condition) {
        this.id = id;
        this.condition = condition;
    }

    public long getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
