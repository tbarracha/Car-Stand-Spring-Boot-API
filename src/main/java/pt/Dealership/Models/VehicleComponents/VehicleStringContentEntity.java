package pt.Dealership.Models.VehicleComponents;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Min;
import pt.Common.entities.NamedEntity;

@MappedSuperclass
public class VehicleStringContentEntity<T> extends NamedEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
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
