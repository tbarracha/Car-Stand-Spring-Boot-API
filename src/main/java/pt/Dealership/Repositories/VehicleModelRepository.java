package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.VehicleModel;

import java.util.List;
import java.util.Optional;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
    @Query("SELECT entity FROM VehicleModel entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<VehicleModel> findByName(String name);

    @Query("SELECT entity FROM VehicleModel entity WHERE LOWER(entity.brand.name) = LOWER(:brandName)")
    List<VehicleModel> findByBrandName(String brandName);

    @Query("SELECT entity FROM VehicleModel entity WHERE entity.brand.id = :brandId")
    List<VehicleModel> findByBrandId(Long brandId);
}
