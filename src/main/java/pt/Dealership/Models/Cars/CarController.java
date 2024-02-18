package pt.Dealership.Models.Cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

@RestController
@RequestMapping("/api/car")
public class CarController extends ControllerBase<Car, Long, CarService> {

    @Autowired
    private CarService service;

    @Override
    protected CarService getService() {
        return service;
    }

    @Override
    protected void populate() {

    }
}
