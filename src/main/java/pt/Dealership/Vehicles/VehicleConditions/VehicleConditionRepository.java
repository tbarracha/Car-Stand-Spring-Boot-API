package pt.Dealership.Vehicles.VehicleConditions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VehicleConditionRepository extends JpaRepository<VehicleCondition, Long> {
    @Query
    Optional<VehicleCondition> findByName(String name);
}
