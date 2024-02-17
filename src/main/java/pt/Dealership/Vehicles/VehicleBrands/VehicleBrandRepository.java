package pt.Dealership.Vehicles.VehicleBrands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {
    @Query
    Optional<VehicleBrand> findByName(String name);
}
