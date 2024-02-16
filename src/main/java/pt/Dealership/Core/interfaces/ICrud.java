package pt.Dealership.Core.interfaces;

public interface ICrud<T, Key> {

    T getById(Key id);

    Iterable<T> getAll();

    T create(T model);

    T update(Key id, T model);

    T delete(Key id);
}
