package pt.Dealership.Services;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;
import pt.Dealership.Enums.*;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;
import pt.Dealership.Models.Vehicles.Car;
import pt.Dealership.Repositories.CarRepository;
import pt.Dealership.Repositories.LicensePlateRepository;
import pt.Dealership.Repositories.VehicleBrandRepository;
import pt.Dealership.Repositories.VehicleConditionRepository;
import pt.Dealership.Repositories.VehicleModelRepository;
import pt.Dealership.Repositories.VehicleStatusRepository;
import pt.Dealership.Repositories.VehicleTypeRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class VehicleService {

    @Autowired
    ColorService colorService;

    private void print(String message, Object... params) {
        System.out.println(String.format(message, params));
    }

    // Initialization
    @PostConstruct
    public void initialize() {
        System.out.println("\n=== Initializing Values ===\n");

        // Status
        for (var value : DefaultVehicleStatus.values()) {
            createStatus(value.toString().toLowerCase());
        }

        // Condition
        for (var value : DefaultVehicleCondition.values()) {
            createCondition(value.toString().toLowerCase());
        }

        // Vehicle Type
        for (var value : DefaultVehicleType.values()) {
            createVehicleType(value.toString().toLowerCase());
        }

        // Default Brands
        for (var value : DefaultVehicleBrands.values()) {
            createBrand(value.toString().toLowerCase());
        }

        // only create cars once we have a colorService
        CompletableFuture<Void> colorServiceInitialized = CompletableFuture.runAsync(() -> {
            while (colorService == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            createExampleCars();
        });
    }

    private void createExampleCars() {
        print("\n=== CREATING example cars! ===\n");

        createCar("VIN123", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.AVAILABLE.toString(), DefaultVehicleCondition.NEW.toString(), "Black", "Toyota", "Camry", "ABC123", 2023, 30000, 5, 4);

        createCar("VIN456", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.SOLD.toString(), DefaultVehicleCondition.USED.toString(), "White", "Honda", "Accord", "XYZ789", 2022, 28000, 5, 4);

        createCar("VIN789", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.RESERVED.toString(), DefaultVehicleCondition.REFURBISHED.toString(), "Silver", "BMW", "X5", "DEF456", 2024, 50000, 5, 4);

        createCar("VIN101", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.AVAILABLE.toString(), DefaultVehicleCondition.NEW.toString(), "Red", "Ford", "Fusion", "GHI789", 2023, 35000, 5, 4);

        createCar("VIN202", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.AVAILABLE.toString(), DefaultVehicleCondition.NEW.toString(), "Blue", "Chevrolet", "Malibu", "JKL012", 2023, 32000, 5, 4);

        createCar("VIN303", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.SOLD.toString(), DefaultVehicleCondition.USED.toString(), "Green", "Nissan", "Altima", "MNO345", 2021, 25000, 5, 4);

        createCar("VIN404", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.RESERVED.toString(), DefaultVehicleCondition.NEW.toString(), "Grey", "Audi", "A4", "PQR678", 2024, 48000, 5, 4);

        createCar("VIN505", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.AVAILABLE.toString(), DefaultVehicleCondition.NEW.toString(), "Yellow", "Tesla", "Model 3", "STU901", 2023, 55000, 5, 4);

        createCar("VIN606", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.AVAILABLE.toString(), DefaultVehicleCondition.NEW.toString(), "Black", "Mercedes-Benz", "C-Class", "VWX234", 2023, 45000, 5, 4);

        createCar("VIN707", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.RESERVED.toString(), DefaultVehicleCondition.REFURBISHED.toString(), "White", "Volkswagen", "Passat", "YZA567", 2024, 40000, 5, 4);

        createCar("VIN808", DefaultVehicleType.CAR.toString(), DefaultVehicleStatus.AVAILABLE.toString(), DefaultVehicleCondition.NEW.toString(), "Red", "Subaru", "Outback", "BCD890", 2023, 38000, 5, 4);

        print("\n=== CREATED example cars! ===\n");
    }





    // Status
    // ----------------------------------------------------------
    @Autowired
    VehicleStatusRepository statusRepository;

    public VehicleStatus findStatus(long id) {
        try {
            return statusRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleStatus findStatus(String name) {
        try {
            return statusRepository.findByName(name).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleStatus> findAllStatus() {
        try {
            return statusRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleStatus saveStatus(VehicleStatus body) {
        return ServiceBase.saveEntity(body, statusRepository);
    }

    public VehicleStatus createStatus(String name) {
        try {
            VehicleStatus status = findStatus(name);

            if (status == null) {
                status = saveStatus(new VehicleStatus(name));
            }

            return status;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Condition
    // ----------------------------------------------------------
    @Autowired
    VehicleConditionRepository conditionRepository;

    public VehicleCondition findCondition(long id) {
        try {
            return conditionRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleCondition findCondition(String name) {
        try {
            return conditionRepository.findByName(name).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleCondition> findAllConditions() {
        try {
            return conditionRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleCondition saveCondition(VehicleCondition body) {
        return ServiceBase.saveEntity(body, conditionRepository);
    }

    public VehicleCondition createCondition(String name) {
        try {
            var status = findCondition(name);

            if (status == null) {
                status = saveCondition(new VehicleCondition(name));
            }

            return status;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Brand
    // ----------------------------------------------------------
    @Autowired
    VehicleBrandRepository brandRepository;

    public VehicleBrand findBrand(long id) {
        try {
            return brandRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleBrand findBrand(String name) {
        try {
            return brandRepository.findByName(name).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleBrand> findAllBrands() {
        try {
            return brandRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleBrand saveBrand(VehicleBrand body) {
        return ServiceBase.saveEntity(body, brandRepository);
    }

    public VehicleBrand createBrand(String name) {
        try {
            var brand = findBrand(name);

            if (brand == null) {
                brand = saveBrand(new VehicleBrand(name));
            }

            return brand;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    // Model
    // ----------------------------------------------------------
    @Autowired
    VehicleModelRepository modelRepository;

    public VehicleModel findModel(long id) {
        id = Math.min(id, 1);

        try {
            return modelRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleModel findModel(String name) {
        try {
            return modelRepository.findByName(name).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleModel> findModelsByBrandId(long brandId) {
        try {
            return modelRepository.findByBrandId(brandId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleModel> findModelsByBrandName(String brandName) {
        try {
            return modelRepository.findByBrandName(brandName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleModel> findAllModels() {
        try {
            return modelRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public VehicleModel saveModel(VehicleModel body) {
        return ServiceBase.saveEntity(body, modelRepository);
    }

    @Transactional
    public VehicleModel createModel(VehicleBrand brand, String name) {
        try {
            if (brand == null)
                return null;

            var model = findModel(name);
            if (model == null) {
                model = modelRepository.save(new VehicleModel(brand, name));
            }

            return model;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public VehicleModel createModel(String brandName, String modelName) {
        try {
            var brand = createBrand(brandName);
            return createModel(brand, modelName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    // License Plate
    // ----------------------------------------------------------
    @Autowired
    LicensePlateRepository licensePlateRepository;

    public LicensePlate findLicensePlate(long id) {
        try {
            return licensePlateRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public LicensePlate findLicensePlate(String name) {
        try {
            return licensePlateRepository.findByName(name).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<LicensePlate> findAllLicensePlates() {
        try {
            return licensePlateRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public LicensePlate saveLicensePlate(LicensePlate body) {
        return ServiceBase.saveEntity(body, licensePlateRepository);
    }

    @Transactional
    public LicensePlate createLicensePlate(String name) {
        try {
            var license = findLicensePlate(name);

            if (license == null) {
                license = licensePlateRepository.save(new LicensePlate(name));
            }

            return license;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public LicensePlate deleteLicensePlate(Long id) {
        try {
            LicensePlate licensePlate = findLicensePlate(id);
            licensePlateRepository.deleteById(id);
            return licensePlate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    // Vehicle Type
    // ----------------------------------------------------------
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    public VehicleType findVehicleType(long id) {
        try {
            return vehicleTypeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VehicleType findVehicleType(String name) {
        try {
            return vehicleTypeRepository.findByName(name).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<VehicleType> findAllVehicleTypes() {
        try {
            return vehicleTypeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public VehicleType saveType(VehicleType body) {
        return ServiceBase.saveEntity(body, vehicleTypeRepository);
    }

    @Transactional
    public VehicleType createVehicleType(String name) {
        try {
            var vehicleType = findVehicleType(name);

            if (vehicleType == null) {
                vehicleType = saveType(new VehicleType(name));
            }

            return vehicleType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Car
    // ----------------------------------------------------------
    @Autowired
    CarRepository carRepository;

    @Transactional
    public Car saveCar(Car body) {
        return ServiceBase.saveEntity(body, carRepository);
    }

    @Transactional
    public Car updateCar(Car body) {
        if (body == null)
            return null;

        Car car = findCar(body.getVin());

        car.setType(body.getType());
        car.setStatus(body.getStatus());
        car.setCondition(body.getCondition());
        car.setColor(body.getColor());
        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setLicensePlate(body.getLicensePlate());
        car.setYearOfAssembly(body.getYearOfAssembly());
        car.setPrice(body.getPrice());
        car.setSeatCount(body.getSeatCount());
        car.setDoorCount(body.getDoorCount());

        car = saveCar(car);

        return car;
    }

    @Transactional
    public Car createCar(Car body) {
        try {
            Car car = findCar(body.getVin());

            if (car == null) {
                car = saveCar(body);
            }

            else {
                car = updateCar(car);
            }

            return car;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Car createCar(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearOfAssembly, double price, int seatCount, int doorCount) {
        try {
            Car car = findCar(vin);

            // create
            if (car == null) {
                car = new Car(vin, type, status, condition, color, brand, model, licensePlate, yearOfAssembly, price, seatCount, doorCount);
                car = saveCar(car);
            }

            // update
            else {
                car = updateCar(car);
            }

            return car;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Car createCar(String vin, String type, String status, String condition, String color, String brand, String model, String licensePlate, int yearOfAssembly, double price, int seatCount, int doorCount) {
        try {
            Car car = findCar(vin);

            // create
            if (car == null) {
                var vBrand = createBrand(brand.toLowerCase());
                var vModel = createModel(vBrand, model.toLowerCase());

                car = new Car(
                        vin,
                        createVehicleType(type.toLowerCase()),
                        createStatus(status.toLowerCase()),
                        createCondition(condition.toLowerCase()),
                        colorService.findByName(color.toLowerCase()),
                        vBrand,
                        vModel,
                        createLicensePlate(licensePlate.toLowerCase()),
                        yearOfAssembly,
                        price,
                        seatCount,
                        doorCount
                );

                car = saveCar(car);
            }

            return car;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Car deleteCar(String vin) {
        try {
            Car car = findCar(vin);

            if (car == null)
                return null;

            car.delete();
            return saveCar(car);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Find Cars
    // ----------------------------------------------------------------------------------

    public Car findCar(String vin) {
        try {
            return carRepository.findByVin(vin).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Car findCar(Car body) {
        try {
            return findCar(body.getVin());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Car> findAllCars() {
        try {
            return carRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Page<Car> findCarsPage(int pageNumber, int size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        return carRepository.findAll(pageRequest);
    }

    public Page<Car> findCarsPage(int pageNumber, int size, String sort) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size, Sort.by(sort));
        return carRepository.findAll(pageRequest);
    }

    // Find cars by brand
    public Page<Car> findCarsByBrand(String brandName, int pageNumber, int pageSize) {
        VehicleBrand brand = findBrand(brandName);
        if (brand == null) {
            return null;
        }
        return carRepository.findByBrand(brand, PageRequest.of(pageNumber, pageSize, Sort.by("brand.Name")));
    }

    // Find cars by model
    public Page<Car> findCarsByModel(String modelName, int pageNumber, int pageSize) {
        VehicleModel model = findModel(modelName);
        if (model == null) {
            return null;
        }
        return carRepository.findByModel(model, PageRequest.of(pageNumber, pageSize, Sort.by("model.Name")));
    }

    // Find cars by color
    public Page<Car> findCarsByColor(String colorName, int pageNumber, int pageSize) {
        Color color = colorService.findByName(colorName);
        if (color == null) {
            return null;
        }
        return carRepository.findByColor(color, PageRequest.of(pageNumber, pageSize));
    }

    // Find cars by status
    public Page<Car> findCarsByStatus(String statusName, int pageNumber, int pageSize) {
        VehicleStatus status = findStatus(statusName);
        if (status == null) {
            return null;
        }

        return carRepository.findByStatus(status, PageRequest.of(pageNumber, pageSize));
    }

    @Transactional
    public Car updateVehicleStatus(String vin, String newStatus) {
        try {
            Car car = findCar(vin);

            if (car == null)
            {
                System.out.println(String.format("Car VIN: '%s' does not exist!", vin));
                return null;
            }

            VehicleStatus status = findStatus(newStatus);

            if (status == null)
            {
                System.out.println(String.format("Status: '%s' does not exist!", newStatus));
                return null;
            }

            car.setStatus(status);
            return saveCar(car);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Car buyCar(String vin, String buyerId, String transactionId) {
        Car car = findCar(vin);

        if (car == null) {
            print("Car VIN: '%s' doesn't exist", vin);
            return null;
        }

        VehicleStatus status = findStatus(DefaultVehicleStatus.SOLD.toString());

        if (status == null) {
            print("Status '%s' doesn't exist!", DefaultVehicleStatus.SOLD.toString());
            return null;
        }

        car.setStatus(status);
        car.setBuyerId(buyerId);
        car.setTransactionId(transactionId);

        return saveCar(car);
    }
}
