package pt.Dealership.Core.interfaces;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public interface ICrudService<T extends RepresentationModel<T>, Key> {
    boolean exists(Key id);

    T getById(Key id);

    List<T> getAll();

    T create(T model);

    T update(Key id, T model);

    T delete(Key id);
}
