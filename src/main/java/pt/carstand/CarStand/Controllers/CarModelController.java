package pt.carstand.CarStand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.carstand.CarStand.Data.CarModelRepository;
import pt.carstand.CarStand.Models.Cars.CarModel;
import pt.carstand.Core.controllers.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/model")
public class CarModelController extends Controller<CarModel, Long> {

    @Autowired
    private CarModelRepository repository;

    // Public API
    // =======================================================================================================

    // Populate
    @GetMapping(value = "/populate", produces = "application/json")
    public ResponseEntity<String> populate() {
        create(new CarModel(1, "BMW"));
        create(new CarModel(2, "Audi"));
        create(new CarModel(3, "Tesla"));
        create(new CarModel(4, "Mercedes"));

        return new ResponseEntity<>("Created 4 Car Models", HttpStatus.OK);
    }

    // Getters
    // -------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarModel> get(@PathVariable("id") Long key) {
        var payload = getByKeyFromRepo(repository, key);

        if (payload != null) {
            payload = addLinks(payload, true, true, true, true);
            return OK(payload);
        }
        else
            return NOT_FOUND(null);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<CarModel> getByName(@PathVariable("name") String name) {
        CarModel payload = repository.findByName(name);

        if (payload != null) {
            payload = addLinks(payload, true, true, true, true);
            return OK(payload);
        }
        else
            return NOT_FOUND(null);
    }


    @GetMapping(produces = "application/json")
    public CollectionModel<CarModel> getAll() {
        var payload = getAllInRepo(repository);

        var collectionModel = CollectionModel.of(payload);
        collectionModel.add(linkTo(methodOn(CarModelController.class).getAll()).withSelfRel().withTitle("Get All"));
        collectionModel.add(linkTo(methodOn(CarModelController.class).create(new CarModel())).withSelfRel().withTitle("Create"));

        return collectionModel;
    }


    // Create & Update
    // -------------------------------------------------------------------------------------------------------
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarModel> create(@RequestBody CarModel model) {
        if (model == null) {
            return NOT_ACCEPTABLE(model);
        }

        createInRepo(repository, model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarModel> update(@PathVariable("id") Long id, CarModel model) {
        if (id == model.getId() && existsByKeyInRepo(repository, id))
        {
            updateInRepo(repository, model);
            return new ResponseEntity<>(model, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    // Delete
    // -------------------------------------------------------------------------------------------------------
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarModel> deleteById(@RequestParam("id") Long key) {
        var payload = get(key).getBody();

        if (payload != null) {
            payload = addLinks(payload, true, true, true, true);
            deleteByKeyInRepo(repository, key);
            return OK(payload);
        } else {
            return NOT_FOUND(payload);
        }
    }


    // Internal methods
    // =======================================================================================================

    @Override
    protected CarModel addLinks(CarModel model, boolean addGetters, boolean addCreate, boolean addUpdate, boolean addDelete) {
        if (addGetters) {
            model.add(linkTo(methodOn(CarModelController.class).get(model.getId())).withSelfRel().withTitle("Get By Id"));                     // link to Get
            model.add(linkTo(methodOn(CarModelController.class).getAll()).withSelfRel().withTitle("Get All"));                                 // link to Get All
        }

        if (addCreate) {
            model.add(linkTo(methodOn(CarModelController.class).create(model)).withSelfRel().withTitle("Create"));                             // link to Create
        }

        if (addUpdate) {
            model.add(linkTo(methodOn(CarModelController.class).update(model.getId(), model)).withSelfRel().withTitle("Update By ID & Body"));  // link to Update
        }

        if (addDelete) {
            model.add(linkTo(methodOn(CarModelController.class).deleteById(model.getId())).withSelfRel().withTitle("Delete By Id"));           // link to Delete by ID
        }

        return model;
    }
}
