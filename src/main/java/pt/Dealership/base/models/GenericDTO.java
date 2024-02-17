package pt.Dealership.base.models;

import org.springframework.hateoas.RepresentationModel;

/**
 * Generic DTO for web transfer & link hold. To hide Entity Properties, mark the properties to hide with @Transient
 * @param <T> Entity Type
 */
public class GenericDTO<T> extends RepresentationModel<GenericDTO<T>> {
    private T entity;

    public GenericDTO(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
