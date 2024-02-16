package pt.Dealership.Vehicles.Cars.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Dealership.Vehicles.Cars.Data.CarBrandRepository;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;
import pt.Dealership.Core.interfaces.ICrudService;

import java.util.List;

@Service
public class CarBrandService implements ICrudService<CarBrand, Long> {

    @Autowired
    private CarBrandRepository repository;

    // Getters
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    public CarBrand getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CarBrand getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<CarBrand> getAll() {
        return repository.findAll();
    }


    // Create & Update
    public CarBrand create(String name) {
        try {
            CarBrand brand = new CarBrand(name);
            return repository.save(brand);
        } catch (Exception e) {
            System.out.println("Car brand already exists!");
            return getByName(name);
        }
    }

    public CarBrand create(CarBrand brand) {
        try {
            return repository.save(brand);
        } catch (Exception e) {
            System.out.println("Car brand already exists!");
            return getByName(brand.getName());
        }
    }

    public CarBrand update(Long id, CarBrand brand) {

        CarBrand targetBrand = getById(id);

        if (targetBrand != null) {
            targetBrand.setName(brand.getName());
            repository.save(targetBrand);
        }

        return targetBrand;
    }


    // Delete
    public CarBrand delete(Long id) {
        CarBrand targetBrand = getById(id);

        if (targetBrand != null) {
            repository.delete(targetBrand);
        }

        return targetBrand;
    }
}
