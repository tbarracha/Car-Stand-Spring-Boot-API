package pt.Dealership.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Common.controllers.ControllerBase;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;
import pt.Dealership.Models.Vehicles.Car;
import pt.Dealership.Services.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Getters for Vehicle Components
    // ----------------------------------------------------------------------------------------------
    @GetMapping("/conditions")
    public ResponseEntity<CollectionModel<EntityModel<VehicleCondition>>> getAllConditions() {
        List<VehicleCondition> conditions = vehicleService.findAllConditions();
        return ControllerBase.getCollectionModelResponse(conditions);
    }

    @GetMapping("/statuses")
    public ResponseEntity<CollectionModel<EntityModel<VehicleStatus>>> getAllStatuses() {
        List<VehicleStatus> statuses = vehicleService.findAllStatus();
        return ControllerBase.getCollectionModelResponse(statuses);
    }

    @GetMapping("/types")
    public ResponseEntity<CollectionModel<EntityModel<VehicleType>>> getAllTypes() {
        List<VehicleType> types = vehicleService.findAllVehicleTypes();
        return ControllerBase.getCollectionModelResponse(types);
    }



    // Brands
    // ----------------------------------------------------------------------------------------------
    @GetMapping("/brands")
    public ResponseEntity<CollectionModel<EntityModel<VehicleBrand>>> getAllBrands() {
        List<VehicleBrand> brands = vehicleService.findAllBrands();
        return ControllerBase.getCollectionModelResponse(brands);
    }

    @GetMapping("/brands/{nameOrId}")
    public ResponseEntity<EntityModel<VehicleBrand>> getBrandByNameOrId(@PathVariable String nameOrId) {
        if (nameOrId.isEmpty())
            return ControllerBase.getEntityModelResponse(null);

        // name
        VehicleBrand brand = vehicleService.findBrand(nameOrId);

        // long
        if (brand == null)
            brand = vehicleService.findBrand(Long.parseLong(nameOrId));

        return ControllerBase.getEntityModelResponse(brand);
    }

    @GetMapping("/brands/id/{id}")
    public ResponseEntity<EntityModel<VehicleBrand>> getBrandById(@PathVariable Long id) {
        VehicleBrand brand = vehicleService.findBrand(id);
        return ControllerBase.getEntityModelResponse(brand);
    }

    @GetMapping("/brands/name/{name}")
    public ResponseEntity<EntityModel<VehicleBrand>> getBrandByName(@RequestParam String name) {
        VehicleBrand brand = vehicleService.findBrand(name);
        return ControllerBase.getEntityModelResponse(brand);
    }

    @PostMapping("/brands")
    public ResponseEntity<EntityModel<VehicleBrand>> createBrand(@RequestParam String name) {
        VehicleBrand brand = vehicleService.createBrand(name);
        return ControllerBase.getEntityModelResponse(brand);
    }



    // Models
    // ----------------------------------------------------------------------------------------------
    @GetMapping("/models")
    public ResponseEntity<CollectionModel<EntityModel<VehicleModel>>> getAllModels() {
        List<VehicleModel> models = vehicleService.findAllModels();
        return ControllerBase.getCollectionModelResponse(models);
    }

    @GetMapping("/models/name/{name}")
    public ResponseEntity<EntityModel<VehicleModel>> getModelByName(@PathVariable String name) {
        VehicleModel model = vehicleService.findModel(name);
        return ControllerBase.getEntityModelResponse(model);
    }

    @GetMapping("/models/brand/{brandNameOrId}")
    public ResponseEntity<CollectionModel<EntityModel<VehicleModel>>> getModelByBrandNameOrId(@PathVariable String brandNameOrId) {
        if (brandNameOrId.isEmpty())
            return ControllerBase.getCollectionModelResponse(null);

        // name
        List<VehicleModel> entity = vehicleService.findModelsByBrandName(brandNameOrId);

        // long
        if (entity.isEmpty())
            entity = vehicleService.findModelsByBrandId(Long.parseLong(brandNameOrId));

        return ControllerBase.getCollectionModelResponse(entity);
    }
    @PostMapping("/models")
    public ResponseEntity<EntityModel<VehicleModel>> createModel(@RequestParam String brandName, @RequestParam String modelName) {
        VehicleModel model = vehicleService.createModel(brandName, modelName);
        return ControllerBase.getEntityModelResponse(model);
    }



    // Cars
    // ----------------------------------------------------------------------------------------------
    @PostMapping("/cars")
    public ResponseEntity<EntityModel<Car>> createCar(@RequestParam String vin, @RequestParam VehicleType type,
                                                      @RequestParam VehicleStatus status, @RequestParam VehicleCondition condition,
                                                      @RequestParam Color color, @RequestParam String brandName, @RequestParam String modelName,
                                                      @RequestParam LicensePlate licensePlate, @RequestParam int yearAssembled,
                                                      @RequestParam double price, @RequestParam int seatCount, @RequestParam int doorCount) {
        VehicleBrand brand = vehicleService.createBrand(brandName);
        VehicleModel model = vehicleService.createModel(brand, modelName);
        Car car = vehicleService.createCar(vin, type, status, condition, color, brand, model, licensePlate,
                yearAssembled, price, seatCount, doorCount);
        return ControllerBase.getEntityModelResponse(car);
    }

    // Read Car
    @GetMapping("/cars/{vin}")
    public ResponseEntity<EntityModel<Car>> getCar(@PathVariable String vin) {
        Car car = vehicleService.findCar(vin);
        return ControllerBase.getEntityModelResponse(car);
    }

    // Read All Cars
    @GetMapping("/cars")
    public ResponseEntity<CollectionModel<EntityModel<Car>>> getAllCars() {
        List<Car> cars = vehicleService.findAllCars();
        return ControllerBase.getCollectionModelResponse(cars);
    }

    // Update Car
    @PutMapping("/cars/{vin}")
    public ResponseEntity<EntityModel<Car>> updateCar(@PathVariable String vin, @RequestParam VehicleType type,
                                                      @RequestParam VehicleStatus status, @RequestParam VehicleCondition condition,
                                                      @RequestParam Color color, @RequestParam String brandName, @RequestParam String modelName,
                                                      @RequestParam LicensePlate licensePlate, @RequestParam int yearAssembled,
                                                      @RequestParam double price, @RequestParam int seatCount, @RequestParam int doorCount) {
        VehicleBrand brand = vehicleService.createBrand(brandName);
        VehicleModel model = vehicleService.createModel(brand, modelName);
        Car car = vehicleService.createCar(vin, type, status, condition, color, brand, model, licensePlate,
                yearAssembled, price, seatCount, doorCount);
        return ControllerBase.getEntityModelResponse(car);
    }

    // Delete Car
    @DeleteMapping("/cars/{vin}")
    public ResponseEntity<Void> deleteCar(@PathVariable String vin) {
        Car car = vehicleService.deleteCar(vin);
        return ControllerBase.getVoidEntityModelResponse(car);
    }
}
