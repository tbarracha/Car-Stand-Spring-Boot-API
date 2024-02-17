package pt.Common.entities;

import pt.Common.interfaces.IDTOable;

public abstract class EntityBase<T> implements IDTOable<EntityBase<T>> {

    public EntityBase() {
    }

    @Override
    public GenericDTO<EntityBase<T>> toDTO() {
        return new GenericDTO<>(this);
    }
}
