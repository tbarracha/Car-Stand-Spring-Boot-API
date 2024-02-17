package pt.Dealership.base.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.base.interfaces.ICrud;

import java.util.List;
import java.util.Optional;

/**
 * Base class for all Service Classes with common CRUD operations
 * @param <T> model type (ex: brand, car, etc)
 * @param <Key> primary key
 * @param <R> repository
 */
public abstract class ServiceBase<T extends RepresentationModel<T>, Key, R extends JpaRepository<T, Key>> implements ICrud<T, Key> {

    // auto wire a private repository in the child class, and override this method to get thae autowired repo
    protected abstract R getRepository();



    // Public API
    // ==============================================================================================================

    @Override
    public T getById(Key id) {
        Optional<T> optionalEntity = getRepository().findById(id);
        return optionalEntity.orElse(null);
    }


    @Override
    public List<T> getAll() {
        return getRepository().findAll();
    }


    @Override
    public T create(T body) {
        try {
            return getRepository().save(body);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T update(Key id, T body) {
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
    public T delete(Key id) {
        Optional<T> optionalEntity = getRepository().findById(id);
        if (optionalEntity.isPresent()) {
            T entity = optionalEntity.get();
            getRepository().deleteById(id);
            return entity;
        }

        return null;
    }



    /*
    // < OLD >
    // still had to write too much!
    // Most services are the same, so I had to make it even more abstract and generic as seen above
    // Public API
    // ==============================================================================================================
    public abstract T getById(Key id);

    public abstract List<T> getAll();

    public abstract T create(T body);

    public abstract T update(Key id, T body);

    public abstract T delete(Key id);
    */
}
