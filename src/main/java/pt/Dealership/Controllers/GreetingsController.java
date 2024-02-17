package pt.Dealership.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Vehicles.VehicleBrands.VehicleBrandController;
import pt.Dealership.Vehicles.VehicleBrands.VehicleBrandService;
import pt.Dealership.Vehicles.Colors.ColorController;
import pt.Dealership.Vehicles.Colors.ColorService;
import pt.Dealership.Vehicles.LicensePlates.LicensePlateController;
import pt.Dealership.Vehicles.LicensePlates.LicensePlateService;
import pt.Dealership.Vehicles.VehicleConditions.VehicleConditionController;
import pt.Dealership.Vehicles.VehicleConditions.VehicleConditionService;
import pt.Dealership.Vehicles.VehicleModels.VehicleModelController;
import pt.Dealership.Vehicles.VehicleModels.VehicleModelService;
import pt.Dealership.Vehicles.VehicleStatus.VehicleStatusController;
import pt.Dealership.Vehicles.VehicleStatus.VehicleStatusService;
import pt.Dealership.Vehicles.VehicleTypes.VehicleTypeController;
import pt.Dealership.Vehicles.VehicleTypes.VehicleTypeService;

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
