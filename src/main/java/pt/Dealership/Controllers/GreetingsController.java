package pt.Dealership.Controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrandController;
import pt.Dealership.Models.Vehicles.Colors.ColorController;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlateController;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleConditionController;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModelController;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatusController;
import pt.Dealership.Models.Vehicles.VehicleTypes.VehicleTypeController;

@RestController
@RequestMapping("/api/greeting")
public class GreetingsController {

    @Autowired
    private VehicleBrandController vehicleBrandController;

    @Autowired
    private ColorController colorController;

    @Autowired
    private LicensePlateController licensePlateController;

    @Autowired
    private VehicleConditionController vehicleConditionController;

    @Autowired
    private VehicleModelController vehicleModelController;

    @Autowired
    private VehicleStatusController vehicleStatusController;

    @Autowired
    private VehicleTypeController vehicleTypeController;


    @PostConstruct
    public void initialize() {
        populate();
    }


    @GetMapping(produces = "application/json")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Api is working fine!", HttpStatus.OK);
    }

    private boolean isPopulated;

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> populate() {
        if (isPopulated) {
            return new ResponseEntity<>("Already populated!", HttpStatus.OK);
        }

        colorController.tryPopulate();
        vehicleStatusController.tryPopulate();
        vehicleTypeController.tryPopulate();
        vehicleConditionController.tryPopulate();
        licensePlateController.tryPopulate();
        vehicleBrandController.tryPopulate();
        vehicleModelController.tryPopulate();

        isPopulated = true;
        return new ResponseEntity<>("Populated data!", HttpStatus.CREATED);
    }
}
