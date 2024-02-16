package pt.carstand.CarStand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.carstand.Core.controllers.Controller;
import pt.carstand.CarStand.Data.CarBrandRepository;
import pt.carstand.CarStand.Models.Cars.CarBrand;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/brand")
public class CarBrandController extends Controller<CarBrand, Long> {

    @Autowired
    private CarBrandRepository repository;

    // Public API
    // =======================================================================================================

    // Populate
    @GetMapping(value = "/populate", produces = "application/json")
    public ResponseEntity<String> populate() {
        create(new CarBrand("BMW"));
        create(new CarBrand("Audi"));
        create(new CarBrand("Tesla"));
        create(new CarBrand("Mercedes"));

        return new ResponseEntity<>("Created 4 brands", HttpStatus.OK);
    }

    // Getters
    // -------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarBrand> get(@PathVariable("id") Long key) {
        var payload = getByKeyFromRepo(repository, key);

        if (payload != null) {
            payload = addLinks(payload, true, true, true, true);
            return OK(payload);
        }
        else
            return NOT_FOUND(null);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<CarBrand> getByName(@PathVariable("name") String name) {
        CarBrand payload = repository.findByName(name);

        if (payload != null) {
            payload = addLinks(payload, true, true, true, true);
            return OK(payload);
        }
        else
            return NOT_FOUND(null);
    }


    @GetMapping(produces = "application/json")
    public CollectionModel<CarBrand> getAll() {
        var payload = getAllInRepo(repository);

        var collectionModel = CollectionModel.of(payload);
        collectionModel.add(linkTo(methodOn(CarBrandController.class).getAll()).withSelfRel().withTitle("Get All"));
        collectionModel.add(linkTo(methodOn(CarBrandController.class).create(new CarBrand())).withSelfRel().withTitle("Create"));

        return collectionModel;
    }


    // Create & Update
    // -------------------------------------------------------------------------------------------------------
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarBrand> create(@RequestBody CarBrand model) {
        if (model == null) {
            return NOT_ACCEPTABLE(model);
        }

        createInRepo(repository, model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarBrand> update(@PathVariable("id") Long id, CarBrand model) {
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
    public ResponseEntity<CarBrand> deleteById(@RequestParam("id") Long key) {
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
    protected CarBrand addLinks(CarBrand model, boolean addGetters, boolean addCreate, boolean addUpdate, boolean addDelete) {
        if (addGetters) {
            model.add(linkTo(methodOn(CarBrandController.class).get(model.getId())).withSelfRel().withTitle("Get By Id"));                     // link to Get
            model.add(linkTo(methodOn(CarBrandController.class).getAll()).withSelfRel().withTitle("Get All"));                                 // link to Get All
        }

        if (addCreate) {
            model.add(linkTo(methodOn(CarBrandController.class).create(model)).withSelfRel().withTitle("Create"));                             // link to Create
        }

        if (addUpdate) {
            model.add(linkTo(methodOn(CarBrandController.class).update(model.getId(), model)).withSelfRel().withTitle("Update By ID & Body"));  // link to Update
        }

        if (addDelete) {
            model.add(linkTo(methodOn(CarBrandController.class).deleteById(model.getId())).withSelfRel().withTitle("Delete By Id"));           // link to Delete by ID
        }

        return model;
    }
}
