package pt.Dealership.Controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Common.controllers.ControllerBase;
import pt.Dealership.Models.Cars.CarController;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModelController;

import java.util.List;

@RestController
@RequestMapping("/api/greeting")
public class GreetingsController {

    @Autowired
    private List<ControllerBase<?, ?, ?>> controllers;

    @PostConstruct
    public void initialize() {
        populate();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Api is working fine!", HttpStatus.OK);
    }

    public static int populatedControllers;
    private boolean isPopulated;

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> populate() {
        if (isPopulated) {
            return new ResponseEntity<>("Already populated!", HttpStatus.OK);
        }

        System.out.println("");
        System.out.println("=== Populating Controllers! ===");
        System.out.println("==============================");
        System.out.println("");
        // populate all controllers
        for (ControllerBase c: controllers) {
            c.tryPopulate();
        }

        // populate cars after all others
        for (ControllerBase c: controllers) {
            if (c instanceof VehicleModelController vc) {
                vc.populateWithModels();
            }

            if (c instanceof CarController carTroller) {
                carTroller.populateWithCars();
            }
        }
        System.out.println("");

        isPopulated = true;
        return new ResponseEntity<>("Populated data!", HttpStatus.CREATED);
    }
}
