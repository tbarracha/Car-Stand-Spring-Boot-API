package pt.Dealership.Models.Vehicles.VehicleModels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
    @Query(VehicleModel.Queries.FIND_BY_NAME)
    Optional<VehicleModel> findByName(String name);

    @Query(VehicleModel.Queries.FIND_WITH_FIRST_LETTER)
    List<VehicleModel> findByFirstLetter(String letter);

    @Query(VehicleModel.Queries.FIND_CONTAINING)
    List<VehicleModel> findContaining(String keyword);

    @Query(VehicleModel.Queries.FIND_WITH_BRAND_ID)
    List<VehicleModel> findByBrandId(Long brandId);

    @Query(VehicleModel.Queries.FIND_WITH_BRAND_NAME)
    List<VehicleModel> findByBrandName(String brandName);
}
