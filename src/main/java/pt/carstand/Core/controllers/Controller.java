package pt.carstand.Core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public abstract class Controller<ModelType extends RepresentationModel<ModelType>, Key> {

    // Get / Read
    // -------------------------------------------------------------------------------------------------------
    protected List<ModelType> getAllInRepo(JpaRepository<ModelType, Key> repository) {
        List<ModelType> result = repository.findAll();
        return result;
    }

    protected ModelType getByKeyFromRepo(JpaRepository<ModelType, Key> repository, Key key) {
        Optional<ModelType> result = repository.findById(key);
        return result.orElse(null);
    }


    // Create & Update
    // -------------------------------------------------------------------------------------------------------
    protected void createInRepo(JpaRepository<ModelType, Key> repository, ModelType model) {
        repository.save(model);
    }

    protected void updateInRepo(JpaRepository<ModelType, Key> repository, ModelType model) {
        repository.save(model);
    }


    // Delete
    // -------------------------------------------------------------------------------------------------------
    protected void deleteInRepo(JpaRepository<ModelType, Key> repository, ModelType model) {
        repository.delete(model);
    }

    protected void deleteByKeyInRepo(JpaRepository<ModelType, Key> repository, Key key) {
        repository.deleteById(key);
    }


    // Exists
    // -------------------------------------------------------------------------------------------------------
    protected boolean existsByKeyInRepo(JpaRepository<ModelType, Key> repository, Key key) {
        return getByKeyFromRepo(repository, key) != null;
    }


    // HTTP Response Entities
    // -------------------------------------------------------------------------------------------------------
    protected ResponseEntity<ModelType> OK(ModelType model) {
        if (model != null)
            return new ResponseEntity<>(model, HttpStatus.OK);
        else
            return OK();
    }

    protected ResponseEntity<ModelType> OK() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected ResponseEntity<ModelType> NOT_FOUND(ModelType model) {
        if (model != null)
            return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
        else
            return NOT_FOUND();
    }

    protected ResponseEntity<ModelType> NOT_FOUND() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<ModelType> NOT_ACCEPTABLE(ModelType model) {
        if (model != null)
            return new ResponseEntity<>(model, HttpStatus.NOT_ACCEPTABLE);
        else
            return NOT_ACCEPTABLE();
    }

    protected ResponseEntity<ModelType> NOT_ACCEPTABLE() {
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    protected abstract ModelType addLinks(ModelType model, boolean addGetters, boolean addCreate, boolean addUpdate, boolean addDelete);

    /*
    protected Brand addLinks(Brand model, boolean addGetById, boolean addGetAll, boolean addUpdate, boolean addDelete) {
        if (addGetById)
            model.add(linkTo(methodOn(BrandController.class).get(model.getId())).withSelfRel());            // link to Get

        if (addGetAll)
            model.add(linkTo(methodOn(BrandController.class).getAll()).withSelfRel());                      // link to Get All

        if (addUpdate)
            model.add(linkTo(methodOn(BrandController.class).update(model.getId(), model)).withSelfRel());  // link to Update

        if (addDelete) {
            model.add(linkTo(methodOn(BrandController.class).delete(model)).withSelfRel());                 // link to Delete
            model.add(linkTo(methodOn(BrandController.class).deleteById(model.getId())).withSelfRel());     // link to Delete by ID
        }

        return model;
    }
    */
}
