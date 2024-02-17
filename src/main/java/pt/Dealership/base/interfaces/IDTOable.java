package pt.Dealership.base.interfaces;

import pt.Dealership.base.models.GenericDTO;

public interface IDTOable<T> {
    GenericDTO<T> toDTO();
}
