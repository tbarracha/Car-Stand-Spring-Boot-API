package pt.Dealership.Vehicles.Base.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Vehicles.Base.Models.VehicleType;
import pt.Dealership.Vehicles.Base.Services.VehicleTypeService;
import pt.Dealership.base.controllers.ControllerBase;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleTypeController extends ControllerBase<VehicleType, Long, VehicleTypeService> {

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

    @Override
    protected VehicleTypeService getService() {
        return service;
    }
}
