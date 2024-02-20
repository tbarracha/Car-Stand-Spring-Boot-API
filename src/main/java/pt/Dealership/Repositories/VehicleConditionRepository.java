package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.VehicleCondition;

import java.util.List;
import java.util.Optional;

public interface VehicleConditionRepository extends JpaRepository<VehicleCondition, Long> {
    @Query("SELECT entity FROM VehicleCondition entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<VehicleCondition> findByName(String name);
}
