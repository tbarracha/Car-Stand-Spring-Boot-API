package pt.Dealership.Vehicles.Cars.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Dealership.base.controllers.ServiceBase;
import pt.Dealership.Vehicles.Cars.Data.CarModelRepository;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;
import pt.Dealership.Vehicles.Cars.Models.CarModel;

import java.util.List;

@Service
public class CarModelService extends ServiceBase<CarModel, Long> {

    @Autowired
    private CarModelRepository repository;

    @Autowired
    private CarBrandService brandService;


    // Getters
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public CarModel getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CarModel getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<CarModel> getAll() {
        return repository.findAll();
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

    public CarModel create(CarModel model) {
        try {
            return repository.save(model);
        } catch (Exception e) {
            System.out.println("Car model already exists!");
            return getByName(model.getName());
        }
    }

    public CarModel update(Long id, CarModel model) {

        CarModel targetModel = getById(id);

        if (targetModel != null) {
            targetModel.setName(model.getName());
            repository.save(targetModel);
        }

        return targetModel;
    }


    // Delete
    public CarModel delete(Long id) {
        CarModel targetModel = getById(id);

        if (targetModel != null) {
            repository.delete(targetModel);
        }

        return targetModel;
    }
}
