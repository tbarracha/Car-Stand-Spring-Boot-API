package pt.Dealership.Vehicles.Cars.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Vehicles.Cars.Models.CarModel;

import java.util.Optional;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    @Query
    Optional<CarModel> findByName(String name);
}
