package pt.Common.interfaces;

import pt.Common.entities.GenericDTO;

public interface IDTOable<T> {
    T toDTO();
}
