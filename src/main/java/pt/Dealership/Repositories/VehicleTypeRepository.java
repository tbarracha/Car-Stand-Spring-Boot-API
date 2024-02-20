package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.VehicleType;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    @Query("SELECT entity FROM VehicleType entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<VehicleType> findByName(String name);
}
