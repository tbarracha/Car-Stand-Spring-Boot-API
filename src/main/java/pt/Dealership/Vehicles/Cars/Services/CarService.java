package pt.Dealership.Vehicles.Cars.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Dealership.Vehicles.Cars.Data.CarBrandRepository;
import pt.Dealership.Vehicles.Cars.Data.CarModelRepository;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;
import pt.Dealership.Vehicles.Cars.Models.CarModel;

/**
 * 1) Controllers recieves HTTP requests;
 * 2) CarService processes those requests & sends back to Controller
 */
@Service
public class CarService {
    // autowire all repositories and make CRUD operations from here
    @Autowired
    CarBrandRepository brandRepository;

    @Autowired
    CarModelRepository modelRepository;


    // Public API
    // ==========================================================================================================

    // Brand
    // ---------------------------------------------------------------------------

    // Getters
    public boolean brandExistsById(Long id) {
        return brandRepository.existsById(id);
    }

    public boolean brandExistsByName(String name) {
        return brandRepository.findByName(name).isPresent();
    }

    public CarBrand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public CarBrand getBrandByName(String name) {
        return brandRepository.findByName(name).orElse(null);
    }


    // Create & Update
    public CarBrand createBrand(String name) {
        CarBrand brand = new CarBrand(name);
        return brandRepository.save(brand);
    }

    public boolean updateBrand(Long id, CarBrand brand) {
        if (brandExistsById(id) == false)
            return false;

        CarBrand targetBrand = getBrandById(id);
        targetBrand.setName(brand.getName());
        brandRepository.save(targetBrand);

        return true;
    }


    // Delete
    public boolean deleteBrand(Long id) {
        if (brandExistsById(id) == false)
            return false;

        brandRepository.deleteById(id);
        return true;
    }



    // Car Model
    // ---------------------------------------------------------------------------

    // Getters
    public boolean modelExistsById(Long id) {
        return modelRepository.existsById(id);
    }

    public CarModel getModelById(Long brandId) {
        return modelRepository.findById(brandId).orElse(null);
    }

    public CarModel getModelByName(String name) {
        return modelRepository.findByName(name).orElse(null);
    }


    // Create & Update
    public CarModel createModel(CarBrand brand, String name) {
        CarModel result = new CarModel(brand, name);
        return modelRepository.save(result);
    }

    public CarModel createModel(Long brandId, String name) {
        CarBrand brand = getBrandById(brandId);
        return createModel(brand, name);
    }

    public boolean updateModel(Long id, CarModel brand) {
        if (modelExistsById(id) == false)
            return false;

        CarModel target = getModelById(id);
        target.setName(brand.getName());
        modelRepository.save(target);

        return true;
    }


    // Delete
    public boolean deleteModel(Long id) {
        if (modelExistsById(id) == false)
            return false;

        modelRepository.deleteById(id);
        return true;
    }
}
