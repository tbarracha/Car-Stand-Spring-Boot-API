package pt.carstand.CarStand.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.carstand.CarStand.Models.Cars.CarBrand;

public interface BrandRepository extends JpaRepository<CarBrand, Long> {
    @Query
    CarBrand findByName(String name);
}
