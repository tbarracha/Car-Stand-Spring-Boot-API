package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.LicensePlate;

import java.util.List;
import java.util.Optional;

public interface LicensePlateRepository extends JpaRepository<LicensePlate, Long> {
    @Query("SELECT entity FROM LicensePlate entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<LicensePlate> findByName(String name);
}
