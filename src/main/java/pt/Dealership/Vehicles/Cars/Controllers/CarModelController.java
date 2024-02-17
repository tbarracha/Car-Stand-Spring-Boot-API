package pt.Dealership.Vehicles.Cars.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.base.controllers.ControllerBase;
import pt.Dealership.Vehicles.Cars.Models.CarModel;
import pt.Dealership.Vehicles.Cars.Services.CarModelService;

@RestController
@RequestMapping("/api/model")
public class CarModelController extends ControllerBase<CarModel, Long, CarModelService> {

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

    @Override
    protected CarModelService getService() {
        return service;
    }

    @PostMapping(value = "/request", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CarModel> create(@RequestBody CarModelRequest body) {
        var entity = service.create(body.brandId, body.name);
        entity = addLinks(entity, true, true, true, true);
        return httpCreatedOrNotAcceptable(entity);
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
