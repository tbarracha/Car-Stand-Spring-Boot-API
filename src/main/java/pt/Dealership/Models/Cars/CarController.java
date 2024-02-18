package pt.Dealership.Models.Cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Models.Vehicles.VehicleController;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModel;
import pt.Dealership.Models.Vehicles.VinGenerator;

import java.util.Random;

@Order(99)
@RestController
@RequestMapping("/api/vehicle/car")
public class CarController extends VehicleController<Car, CarService> {

    @Autowired
    private CarService service;

    @Override
    protected CarService getService() {
        return service;
    }

    @Override
    protected void populate() {
        System.out.println(this.getClass().getSimpleName() + ", wont populate yet");
    }

    @Override
    public void tryLatePopulate() {
        if (isLatePopulated)
            return;

        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            VehicleModel model = modelService.findById(random.nextLong(1, 14));

            getService().create(new Car(
                    VinGenerator.generateVin(),
                    typeService.findById(i + 1L), // Varying types
                    statusService.findById((i + 1) % 2 + 1L), // Varying status
                    conditionService.findById((i + 2) % 3 + 1L), // Varying conditions
                    colorService.findById((i + 2) % 3 + 1L), // Varying colors
                    model.getBrand(), // Varying brands
                    model, // Varying models
                    licensePlateService.create(new LicensePlate("XYZ00" + (i + 1))),
                    2023 - i, // Decreasing year of assembly
                    20000.00 + (i * 1000), // Increasing price
                    5,
                    4
            ));
        }

        isLatePopulated = true;
    }

}
