package pt.Dealership.Models.Vehicles.Colors;

import jakarta.persistence.*;
import pt.Common.entities.EntityBase;

@Entity
public class Color extends EntityBase<Color> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    static final class Queries {
        public static final String FIND_BY_NAME = "SELECT entity FROM Color entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_WITH_FIRST_LETTER = "SELECT entity FROM Color entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FIND_CONTAINING = "SELECT entity FROM Color entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
        public static final String FIND_BY_HEXADECIMAL = "SELECT entity FROM Color entity WHERE LOWER(entity.hexadecimal) = LOWER(:hexadecimal)";
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
