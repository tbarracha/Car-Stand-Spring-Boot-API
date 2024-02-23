package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.*;

@Entity
public class LicensePlate{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String license;
    private String country;
    private String vin;


    public LicensePlate() {
        super();
    }

    public LicensePlate(String license, String country, String vin) {
        this.license = license;
        this.country = country;
        this.vin = vin;
    }

    public long getId() {
        return id;
    }


    // license
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }


    // country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    // VIN
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
