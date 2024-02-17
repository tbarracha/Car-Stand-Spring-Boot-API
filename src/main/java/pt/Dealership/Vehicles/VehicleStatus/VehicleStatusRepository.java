package pt.Dealership.Vehicles.VehicleStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
    @Query
    Optional<VehicleStatus> findByName(String name);
}
