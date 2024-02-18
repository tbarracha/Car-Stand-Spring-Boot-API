package pt.Dealership.Models.Vehicles.VehicleBrands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {
    @Query(VehicleBrand.Queries.FIND_BY_NAME)
    Optional<VehicleBrand> findByName(String name);

    @Query(VehicleBrand.Queries.FIND_WITH_FIRST_LETTER)
    List<VehicleBrand> findByFirstLetter(String letter);

    @Query(VehicleBrand.Queries.FIND_CONTAINING)
    List<VehicleBrand> findContaining(String keyword);
}
