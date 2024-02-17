package pt.Dealership.base.interfaces;

import pt.Dealership.base.dto.GenericDTO;

public interface IDTOable<T> {
    GenericDTO<T> toDTO(T entity);
}
