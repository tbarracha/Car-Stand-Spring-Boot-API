package pt.Common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import pt.Common.interfaces.INameable;

@MappedSuperclass
public abstract class NamedEntity<T> implements INameable {
    @Max(64)
    @Column(nullable = false, unique = true)
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
