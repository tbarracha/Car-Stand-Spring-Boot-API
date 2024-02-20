package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.VehicleStatus;

import java.util.List;
import java.util.Optional;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
    @Query("SELECT entity FROM VehicleStatus entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<VehicleStatus> findByName(String name);
}
