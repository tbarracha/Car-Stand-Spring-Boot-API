package pt.Dealership.Vehicles.Cars.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Dealership.base.controllers.ServiceBase;
import pt.Dealership.Vehicles.Cars.Data.CarModelRepository;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;
import pt.Dealership.Vehicles.Cars.Models.CarModel;

import java.util.List;

@Service
public class CarModelService extends ServiceBase<CarModel, Long, CarModelRepository> {

    @Autowired
    private CarModelRepository repository;

    @Autowired
    private CarBrandService brandService;

    @Override
    protected CarModelRepository getRepository() {
        return repository;
    }

    public CarModel getByName(String name) {
        return repository.findByName(name).orElse(null);
    }


    // Create & Update
    public CarModel create(Long brandId, String name) {
        CarBrand brand = brandService.getById(brandId);
        CarModel model = new CarModel(brand, name);

        return create(model);
    }

    public CarModel create(CarBrand brand, String name) {
        CarModel model = new CarModel(brand, name);
        return create(model);
    }

    @Override
    protected void updateEntityProperties(CarModel body, CarModel entity) {

    }
}
