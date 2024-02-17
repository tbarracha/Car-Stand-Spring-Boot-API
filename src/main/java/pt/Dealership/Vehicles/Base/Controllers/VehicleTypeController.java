package pt.Dealership.Vehicles.Base.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Vehicles.Base.Models.VehicleType;
import pt.Dealership.Vehicles.Base.Services.VehicleTypeService;
import pt.Dealership.base.controllers.ControllerBase;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleTypeController extends ControllerBase<VehicleType, Long> {

    @Autowired
    private VehicleTypeService service;

    private boolean populated;

    @PostMapping(value = "/populate")
    public ResponseEntity<String> populate() {

        if (populated) {
            return httpOk();
        }

        service.create("Car");
        service.create("Motorbike");

        return httpOk("Populated Vehicles!");
    }


    // Getters
    // -------------------------------
    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VehicleType> getById(@PathVariable("id") Long id) {
        var entity = service.getById(id);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<VehicleType> getByName(@PathVariable("name") String name) {
        var entity = service.getByName(name);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }

    @Override
    @GetMapping(produces = "application/json")
    public CollectionModel<VehicleType> getAll() {
        var entityList = service.getAll();
        CollectionModel<VehicleType> collectionModel = CollectionModel.of(entityList);
        collectionModel = addLinks(collectionModel, true, true);
        return collectionModel;
    }


    // Create & Update
    // -------------------------------
    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<VehicleType> create(@RequestBody VehicleType body) {
        var entity = service.create(body);
        entity = addLinks(entity, true, true, true, true);
        return httpCreatedOrNotAcceptable(entity);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<VehicleType> update(@PathVariable("id") Long id, @RequestBody VehicleType body) {
        var entity = service.update(id, body);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }


    // Delete
    // -------------------------------
    @Override
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<VehicleType> delete(@PathVariable("id") Long id) {
        var entity = service.delete(id);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }
}
