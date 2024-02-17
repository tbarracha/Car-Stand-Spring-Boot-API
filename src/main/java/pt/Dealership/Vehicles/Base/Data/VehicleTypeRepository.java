package pt.Dealership.Vehicles.Base.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Vehicles.Base.Models.VehicleType;
import pt.Dealership.Vehicles.Cars.Models.CarBrand;

import java.util.Optional;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    @Query
    Optional<VehicleType> findByName(String name);
}
