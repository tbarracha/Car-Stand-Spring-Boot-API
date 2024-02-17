package pt.Dealership.Vehicles.VehicleTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    @Query
    Optional<VehicleType> findByType(String type);
}
