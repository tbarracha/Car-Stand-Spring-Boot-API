package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.VehicleBrand;

import java.util.List;
import java.util.Optional;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {
    @Query("SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<VehicleBrand> findByName(String name);
}
