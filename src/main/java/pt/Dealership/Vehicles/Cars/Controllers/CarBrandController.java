package pt.Dealership.Vehicles.Cars.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Vehicles.Cars.Services.CarBrandService;
import pt.Dealership.base.controllers.ControllerBase;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;

@RestController
@RequestMapping("/api/brand")
public class CarBrandController extends ControllerBase<CarBrand, Long, CarBrandService> {

    @Autowired
    private CarBrandService service;

    private boolean populated;

    @PostMapping(value = "/populate")
    public ResponseEntity<String> populate() {

        if (populated) {
            return httpOk();
        }

        service.create("Audi");
        service.create("BWM");
        service.create("Mercedes");
        service.create("Tesla");

        return httpOk("Populated brands!");
    }

    @Override
    protected CarBrandService getService() {
        return service;
    }
}
