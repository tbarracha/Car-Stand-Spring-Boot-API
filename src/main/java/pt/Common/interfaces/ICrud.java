package pt.Common.interfaces;

/**
 * Interface with common CRUD operations
 * @param <T> model type (ex: brand, car, etc)
 * @param <Key> primary key
 */
public interface ICrud<T, Key> {

    T getById(Key id);

    Iterable<T> getAll();

    T create(T model);

    T update(Key id, T model);

    T delete(Key id);
}
