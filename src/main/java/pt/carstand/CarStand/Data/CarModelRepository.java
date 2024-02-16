package pt.carstand.CarStand.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.carstand.CarStand.Models.Cars.CarBrand;
import pt.carstand.CarStand.Models.Cars.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    @Query
    CarModel findByName(String name);


}
