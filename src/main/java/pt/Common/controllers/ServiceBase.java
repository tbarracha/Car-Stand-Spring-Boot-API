package pt.Common.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Base class for all Service Classes with common CRUD operations
 * @param <T> model type (ex: brand, car, etc)
 * @param <K> primary key
 * @param <R> repository
 */
public abstract class ServiceBase<T, K, R extends JpaRepository<T, K>> extends ServiceBaseParent<T, K> {

    // auto wire a private repository in the child class, and override this method to get thae autowired repo
    protected abstract R getRepository();



    // Public API
    // ==============================================================================================================

    @Override
    public T findById(K id) {
        Optional<T> optionalEntity = getRepository().findById(id);
        return optionalEntity.orElse(null);
    }


    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }


    @Override
    public T create(T body) {
        try {
            return getRepository().save(body);
        } catch (Exception e) {
            e.printStackTrace();
            return tryGetEntity(body);
        }
    }

    // if it's not possible to create an entity, use this method to try and get one with current properties
    protected abstract T tryGetEntity(T body);

    @Override
    public T update(K id, T body) {
        Optional<T> optionalEntity = getRepository().findById(id);
        if (optionalEntity.isPresent()) {
            T entity = optionalEntity.get();
            updateEntityProperties(body, entity);
            return getRepository().save(body);
        }

        return null;
    }

    // Update entity properties here
    // since we don't know what type of entity it is yet, we use this method to apply the changes
    // Example: entity.setName(body.getName());
    protected abstract void updateEntityProperties(T updatedBody, T entityToUpdate);


    @Override
    public T delete(K id) {
        Optional<T> optionalEntity = getRepository().findById(id);
        if (optionalEntity.isPresent()) {
            T entity = optionalEntity.get();
            getRepository().deleteById(id);
            return entity;
        }

        return null;
    }


}
