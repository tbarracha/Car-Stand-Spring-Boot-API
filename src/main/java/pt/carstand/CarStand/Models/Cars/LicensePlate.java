package pt.carstand.CarStand.Models.Cars;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class LicensePlate extends RepresentationModel<LicensePlate> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String licensePlate;

    public LicensePlate() {

    }

    public LicensePlate(long id, String value) {
        this.id = id;
        this.licensePlate = value;
    }

    public long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void  setId(long id) {
        this.id = id;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
