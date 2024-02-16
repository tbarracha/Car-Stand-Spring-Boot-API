package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Color extends RepresentationModel<Color> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String name;

    @Column(nullable = false)
    String hexadecimalValue;

    public Color() {

    }

    public Color(long id, String name, String hexadecimalValue) {
        this.id = id;
        this.name = name;
        this.hexadecimalValue = hexadecimalValue;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHexadecimalValue() {
        return hexadecimalValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHexadecimalValue(String hexadecimalValue) {
        this.hexadecimalValue = hexadecimalValue;
    }
}
