package pt.Dealership.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;
import pt.Dealership.Models.VehicleComponents.*;
import pt.Dealership.Models.Vehicles.Car;
import pt.Dealership.Models.Vehicles.CarDTO;
import pt.Dealership.Services.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Getters for Vehicle Components
    // ----------------------------------------------------------------------------------------------
    @GetMapping("/conditions")
    public CollectionModel<VehicleCondition> getAllConditions() {
        List<VehicleCondition> entityList = vehicleService.findAllConditions();
        var collectionModel = CollectionModel.of(entityList);

        return collectionModel;
    }

    @GetMapping("/statuses")
    public CollectionModel<VehicleStatus> getAllStatuses() {
        List<VehicleStatus> entityList = vehicleService.findAllStatus();
        var collectionModel = CollectionModel.of(entityList);

        return collectionModel;
    }

    @GetMapping("/types")
    public CollectionModel<VehicleType> getAllTypes() {
        List<VehicleType> entityList = vehicleService.findAllVehicleTypes();
        var collectionModel = CollectionModel.of(entityList);

        return collectionModel;
    }



    // Brands
    // ----------------------------------------------------------------------------------------------
    @GetMapping("/brands")
    public CollectionModel<VehicleBrand> getAllBrands() {
        List<VehicleBrand> entityList = vehicleService.findAllBrands();
        var collectionModel = CollectionModel.of(entityList);

        return collectionModel;
    }

    @GetMapping("/brands/{nameOrId}")
    public ResponseEntity<EntityModel<VehicleBrand>> getBrandByNameOrId(@PathVariable String nameOrId) {
        if (nameOrId.isEmpty())
            return ControllerBase.getEntityModelResponse(null);

        // name
        VehicleBrand entityList = vehicleService.findBrand(nameOrId);

        // long
        if (entityList == null)
            entityList = vehicleService.findBrand(Long.parseLong(nameOrId));

        return ControllerBase.getEntityModelResponse(entityList);
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



    // Cars
    // ==============================================================================================

    // Create
    // ----------------------------------------------------------------------------------------------
    @PostMapping("/cars")
    public ResponseEntity<CarDTO> createCar(@RequestBody Car carBody) {
        if (carBody == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Car car = vehicleService.createCar(carBody);

        if (car != null) {
            var carDTO = car.toDTO();

            carDTO.add(generateCarLinkGet(car));
            carDTO.add(generateCarLinkGetAll());
            carDTO.add(generateCarLinkCreate(car));
            carDTO.add(generateCarLinkDelete(car));

            return ResponseEntity.ok(carDTO);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    // http://localhost:8080/api/vehicles/cars/params?vin=zin123&type=car&status=reserved&condition=used&color=red&brandName=bmw&modelName=bm%20123&licensePlate=13-ab-23&yearAssembled=2020&price=10000&seatCount=5&doorCount=918512
    @PostMapping("/cars/params")
    public ResponseEntity<CarDTO> createCar(@RequestParam String vin, @RequestParam String type,
                                                      @RequestParam String status, @RequestParam String condition,
                                                      @RequestParam String color, @RequestParam String brandName, @RequestParam String modelName,
                                                      @RequestParam String licensePlate, @RequestParam String country, @RequestParam int yearAssembled,
                                                      @RequestParam double price, @RequestParam int seatCount, @RequestParam int doorCount) {

        Car car = vehicleService.createCar(vin, type, status, condition, color, brandName, modelName, licensePlate, country, yearAssembled, price, seatCount, doorCount);

        if (car != null) {
            var carDTO = car.toDTO();

            carDTO.add(generateCarLinkGet(car));
            carDTO.add(generateCarLinkGetAll());
            carDTO.add(generateCarLinkCreate(car));
            carDTO.add(generateCarLinkDelete(car));

            return ResponseEntity.ok(carDTO);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }



    // Get cars
    // ----------------------------------------------------------------------------------------------
    @GetMapping("/cars/{vin}")
    public ResponseEntity<CarDTO> getCar(@PathVariable String vin) {
        Car car = vehicleService.findCar(vin);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var carDTO = car.toDTO();

        carDTO.add(generateCarLinkGet(car));
        carDTO.add(generateCarLinkGetAll());
        carDTO.add(generateCarLinkCreate(car));
        carDTO.add(generateCarLinkDelete(car));

        return ResponseEntity.ok(carDTO);
    }

    @GetMapping("/cars")
    public CollectionModel<CarDTO> getCars(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size, @RequestParam Optional<String> sort) {

        int pageIndex = page.orElse(0);
        int pageSize = size.orElse(10);
        String pageSort = sort.orElse("brand");

        var cars = vehicleService.findCarsPage(pageIndex, pageSize, pageSort);
        return getCarCollectionModel(cars);
    }

    // Find cars by brand
    @GetMapping("/cars/brand/{brandName}")
    public CollectionModel<CarDTO> getCarsByBrand(@PathVariable String brandName,
                                                                            @RequestParam int pageNumber,
                                                                            @RequestParam int pageSize) {
        Page<Car> cars = vehicleService.findCarsByBrand(brandName, pageNumber, pageSize);
        return getCarCollectionModel(cars);
    }

    // Find cars by model
    @GetMapping("/cars/model/{modelName}")
    public CollectionModel<CarDTO> getCarsByModel(@PathVariable String modelName,
                                                                            @RequestParam int pageNumber,
                                                                            @RequestParam int pageSize) {
        Page<Car> cars = vehicleService.findCarsByModel(modelName, pageNumber, pageSize);
        return getCarCollectionModel(cars);
    }

    // Find cars by color
    @GetMapping("/cars/color/{colorName}")
    public CollectionModel<CarDTO> getCarsByColor(@PathVariable String colorName,
                                                                            @RequestParam int pageNumber,
                                                                            @RequestParam int pageSize) {
        Page<Car> cars = vehicleService.findCarsByColor(colorName, pageNumber, pageSize);
        return getCarCollectionModel(cars);
    }

    // Find cars by status
    @GetMapping("/cars/status/{statusName}")
    public CollectionModel<CarDTO> getCarsByStatus(@PathVariable String statusName,
                                                                             @RequestParam int pageNumber,
                                                                             @RequestParam int pageSize) {
        Page<Car> cars = vehicleService.findCarsByStatus(statusName, pageNumber, pageSize);
        return getCarCollectionModel(cars);
    }




    // Update & Delete
    // ----------------------------------------------------------------------------------------------
    @PutMapping("/car/{vin}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String vin, @RequestBody Car carBody) {
        if (vin.isEmpty() || carBody == null || !vin.equalsIgnoreCase(carBody.getVin()))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Car car = vehicleService.createCar(carBody);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var carDTO = car.toDTO();

        carDTO.add(generateCarLinkGet(car));
        carDTO.add(generateCarLinkGetAll());
        carDTO.add(generateCarLinkCreate(car));
        carDTO.add(generateCarLinkDelete(car));

        return ResponseEntity.ok(carDTO);
    }

    // buy car
    @PostMapping("car/{vin}")
    public ResponseEntity<CarDTO> buyCar(@PathVariable String vin, @RequestParam String buyerId, @RequestParam String sellerId, @RequestParam double purchasePrice, @RequestParam String transactionId) {
        if (vin.isEmpty() || buyerId.isEmpty() || sellerId.isEmpty() || transactionId.isEmpty() || purchasePrice <= 0)
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        Car car = vehicleService.buyCar(vin, buyerId, sellerId, purchasePrice, transactionId);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var carDTO = car.toDTO();

        carDTO.add(generateCarLinkGet(car));
        carDTO.add(generateCarLinkGetAll());
        carDTO.add(generateCarLinkCreate(car));
        carDTO.add(generateCarLinkDelete(car));

        return ResponseEntity.ok(carDTO);
    }

    // Delete Car
    @DeleteMapping("/cars/{vin}")
    public ResponseEntity<CarDTO> deleteCar(@PathVariable String vin) {
        Car car = vehicleService.deleteCar(vin);

        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var carDTO = car.toDTO();

        carDTO.add(generateCarLinkGetAll());
        carDTO.add(generateCarLinkCreate(car));

        return ResponseEntity.ok(carDTO);
    }



    // Internal
    // ----------------------------------------------------------------------------------------------

    private Link generateCarLinkGet(Car car) {
        return linkTo(methodOn(this.getClass()).getCar(car.getVin())).withRel("Get Car");
    }

    private Link generateCarLinkCreate(Car car) {
        return linkTo(methodOn(this.getClass()).createCar(car)).withRel("Create Car");
    }

    private Link generateCarLinkUpdate(Car car) {
        return linkTo(methodOn(this.getClass()).updateCar(car.getVin(), car)).withRel("Update Car");
    }

    private Link generateCarLinkDelete(Car car) {
        return linkTo(methodOn(this.getClass()).deleteCar(car.getVin())).withRel("Delete Car");
    }

    private Link generateCarLinkGetAll() {
        int page = 0;
        int size = 5;
        String sort = "price";

        return linkTo(methodOn(this.getClass()).getCars(Optional.of(page), Optional.of(size), Optional.of(sort))).withRel("Get All Cars");
    }

    private CollectionModel<CarDTO> getCarCollectionModel(Iterable<Car> cars) {

        if (cars != null) {
            var carDTOs = new ArrayList<CarDTO>();
            for (Car car: cars) {
                CarDTO dto = car.toDTO();
                dto.add(generateCarLinkGet(car));

                carDTOs.add(dto);
            }

            return CollectionModel.of(carDTOs);
        }

        return CollectionModel.of(null);
    }
}
