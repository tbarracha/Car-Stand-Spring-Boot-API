package pt.Dealership.Vehicles.Cars.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;

import java.util.Optional;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    @Query
    Optional<CarBrand> findByName(String name);
}
