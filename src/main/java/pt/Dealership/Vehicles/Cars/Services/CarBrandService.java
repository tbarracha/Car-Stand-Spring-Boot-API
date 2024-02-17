package pt.Dealership.Vehicles.Cars.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Dealership.base.controllers.ServiceBase;
import pt.Dealership.Vehicles.Cars.Data.CarBrandRepository;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;


@Service
public class CarBrandService extends ServiceBase<CarBrand, Long, CarBrandRepository> {

    @Autowired
    private CarBrandRepository repository;

    @Override
    public CarBrandRepository getRepository() {
        return repository;
    }

    public CarBrand getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public CarBrand create(String name) {
        CarBrand brand = new CarBrand(name);
        return create(brand);
    }

    @Override
    protected void updateEntityProperties(CarBrand body, CarBrand entity) {

    }
}
