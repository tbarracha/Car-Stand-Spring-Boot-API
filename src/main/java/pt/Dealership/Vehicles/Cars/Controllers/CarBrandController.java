package pt.Dealership.Vehicles.Cars.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Vehicles.Cars.Services.CarBrandService;
import pt.Dealership.Core.controllers.ControllerBase;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;

@RestController
@RequestMapping("/api/brand")
public class CarBrandController extends ControllerBase<CarBrand, Long> {

    @Autowired
    private CarBrandService service;


    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarBrand> getById(@PathVariable("id") Long id) {
        var entity = service.getById(id);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<CarBrand> getByName(@PathVariable("name") String name) {
        var entity = service.getByName(name);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }

    @Override
    @GetMapping(produces = "application/json")
    public CollectionModel<CarBrand> getAll() {
        var entityList = service.getAll();
        CollectionModel<CarBrand> collectionModel = CollectionModel.of(entityList);
        collectionModel = addLinks(collectionModel, true, true);
        return collectionModel;
    }

    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarBrand> create(@RequestBody CarBrand body) {
        var entity = service.create(body);
        return httpCreatedOrNotAcceptable(entity);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarBrand> update(@PathVariable("id") Long id, @RequestBody CarBrand body) {
        var entity = service.update(id, body);
        return httpOkOrNotFound(entity);
    }

    @Override
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarBrand> delete(@PathVariable("id") Long id) {
        var entity = service.delete(id);
        return httpOkOrNotFound(entity);
    }
}
