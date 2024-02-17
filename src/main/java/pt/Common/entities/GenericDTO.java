package pt.Common.entities;

import org.springframework.hateoas.RepresentationModel;

/**
 * Generic DTO for web transfer & link data. To hide sensitive Entity Properties (ex: password), mark with @Transient on top of that property
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
