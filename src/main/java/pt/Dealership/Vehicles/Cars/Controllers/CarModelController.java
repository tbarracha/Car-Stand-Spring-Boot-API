package pt.Dealership.Vehicles.Cars.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.base.controllers.ControllerBase;
import pt.Dealership.Vehicles.Cars.Models.CarModel;
import pt.Dealership.Vehicles.Cars.Services.CarModelService;

@RestController
@RequestMapping("/api/model")
public class CarModelController extends ControllerBase<CarModel, Long> {

    @Autowired
    private CarModelService service;

    private boolean populated;

    @PostMapping(value = "/populate")
    public ResponseEntity<String> populate() {

        if (populated) {
            return httpOk();
        }



        return httpOk("Populated brands!");
    }

    // Public API
    // ==============================================================================================================

    // Getters
    // -------------------------------
    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarModel> getById(@PathVariable("id") Long id) {
        var entity = service.getById(id);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<CarModel> getByName(@PathVariable("name") String name) {
        var entity = service.getByName(name);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }

    @Override
    @GetMapping(produces = "application/json")
    public CollectionModel<CarModel> getAll() {
        var entityList = service.getAll();
        CollectionModel<CarModel> collectionModel = CollectionModel.of(entityList);
        collectionModel = addLinks(collectionModel, true, true);
        return collectionModel;
    }


    // Create & Update
    // -------------------------------
    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarModel> create(@RequestBody CarModel body) {
        var entity = service.create(body);
        entity = addLinks(entity, true, true, true, true);
        return httpCreatedOrNotAcceptable(entity);
    }

//    /*
    @PostMapping(value = "/request", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarModel> create(@RequestBody CarModelRequest body) {
        var entity = service.create(body.brandId, body.name);
        entity = addLinks(entity, true, true, true, true);
        return httpCreatedOrNotAcceptable(entity);
    }
//    */

    @Override
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarModel> update(@PathVariable("id") Long id, @RequestBody CarModel body) {
        var entity = service.update(id, body);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }


    // Delete
    // -------------------------------
    @Override
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CarModel> delete(@PathVariable("id") Long id) {
        var entity = service.delete(id);
        entity = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(entity);
    }



    // Internal
    // ==============================================================================================================

    // DTO request helpers
    // ---------------------------------------------------------
    static class CarModelRequest {
        public Long brandId;
        public String name;

        public CarModelRequest(Long brandId, String name) {
            this.brandId = brandId;
            this.name = name;
        }
    }
}
