package pt.Dealership.Models.Cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;
import pt.Dealership.Models.Vehicles.Colors.Color;
import pt.Dealership.Models.Vehicles.Colors.ColorService;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlateService;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrand;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrandService;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleCondition;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleConditionService;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModel;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModelService;
import pt.Dealership.Models.Vehicles.VehicleService;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatus;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatusService;
import pt.Dealership.Models.Vehicles.VehicleTypes.VehicleType;
import pt.Dealership.Models.Vehicles.VehicleTypes.VehicleTypeService;

@Service
public class CarService extends VehicleService<Car> {

    @Autowired
    private CarRepository repository;

    @Autowired
    private ColorService colorService;
    @Autowired
    private LicensePlateService licensePlateService;
    @Autowired
    private VehicleBrandService brandService;
    @Autowired
    private VehicleConditionService conditionService;
    @Autowired
    private VehicleModelService modelService;
    @Autowired
    private VehicleStatusService statusService;
    @Autowired
    private VehicleTypeService typeService;

    @Override
    protected CarRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(Car updatedBody, Car entityToUpdate) {

    }

    @Override
    protected Car tryGetEntity(Car body) {
        try {
            Car car = findById(body.getVin());
            return car;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Car create(String vin, VehicleType type, VehicleStatus status, VehicleCondition condition, Color color, VehicleBrand brand, VehicleModel model, LicensePlate licensePlate, int yearAssembled, double price, int seatCount, int doorCount)
    {
        return create(new Car(vin, type, status, condition, color, brand, model, licensePlate, yearAssembled, price, seatCount, doorCount));
    }


    /*
    public Car create(String vin, long typeId, long brandId, long modelId, String licensePlate, int yearOfAssembly, Color color, long statusId, long conditionId, double price, int seatCount, int doorCount)
    {
        Car car = new Car();

        car.setVin(vin);
        car.setType();
        car.setBrand();
        car.setModel();
        car.setLicensePlate(licensePlateService.create(new LicensePlate(licensePlate)));
        car.getYearOfAssembly();
        car.setColor();
        car.setStatus();
        car.setCondition();
        car.setPrice();
        car.setSeatCount(seatCount);
        car.setDoorCount(doorCount);

        return create(car);
    }
    */
}
