package pt.Dealership.Models;

import pt.Common.entities.EntityBase;

public abstract class NamedEntity<T> extends EntityBase<NamedEntity<T>> {

    public String name;

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
