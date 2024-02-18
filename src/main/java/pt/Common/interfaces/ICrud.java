package pt.Common.interfaces;

/**
 * Interface with common CRUD operations
 * @param <T> model type (ex: brand, car, etc)
 * @param <K> primary key
 */
public interface ICrud<T, K> {

    T findById(K id);

    Iterable<T> findAll();

    T create(T model);

    T update(K id, T model);

    T delete(K id);
}
