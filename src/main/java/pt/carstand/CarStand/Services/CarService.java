package pt.carstand.CarStand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.carstand.CarStand.Data.CarBrandRepository;
import pt.carstand.CarStand.Data.CarModelRepository;
import pt.carstand.CarStand.Models.Cars.CarBrand;

@Service
public class CarService {
    // autowire all repositories and make calls from here
    @Autowired
    CarBrandRepository carBrandRepository;

    @Autowired
    CarModelRepository carModelRepository;

    public CarBrand createCarBrand(String brandName) {
        CarBrand brand = new CarBrand(brandName);
        return carBrandRepository.save(brand);
    }
}
