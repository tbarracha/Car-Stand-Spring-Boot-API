package pt.Dealership.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Color extends RepresentationModel<Color> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Min(1)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String hexadecimal;

    public Color() {

    }

    public Color(String name, String hexadecimal) {
        this.name = name;
        this.hexadecimal = hexadecimal;
    }

    public Color(Long id, String name, String hexadecimal) {
        this.id = id;
        this.name = name;
        this.hexadecimal = hexadecimal;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }
}
