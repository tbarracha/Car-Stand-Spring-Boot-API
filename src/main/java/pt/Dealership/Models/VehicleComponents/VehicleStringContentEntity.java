package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import pt.Common.entities.NamedEntity;

@MappedSuperclass
public class VehicleStringContentEntity<T> extends NamedEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public VehicleStringContentEntity() {
        super();
    }

    public VehicleStringContentEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
