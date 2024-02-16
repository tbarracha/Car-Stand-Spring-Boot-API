package pt.Dealership.Core.controllers;


import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.Core.interfaces.ICrud;

import java.util.List;

public abstract class ServiceBase<T extends RepresentationModel<T>, Key> implements ICrud<T, Key> {

    // Public API
    // ==============================================================================================================
    public abstract T getById(Key id);

    public abstract List<T> getAll();

    public abstract T create(T body);

    public abstract T update(Key id, T body);

    public abstract T delete(Key id);
}
