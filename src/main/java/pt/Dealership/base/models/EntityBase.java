package pt.Dealership.base.models;

import pt.Dealership.base.interfaces.IDTOable;

public abstract class EntityBase<T> implements IDTOable<EntityBase<T>> {

    @Override
    public GenericDTO<EntityBase<T>> toDTO() {
        return new GenericDTO<>(this);
    }
}
