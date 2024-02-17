package pt.Dealership.Vehicles.VehicleTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    @Query(VehicleType.Queries.FIND_BY_NAME)
    Optional<VehicleType> findByName(String name);

    @Query(VehicleType.Queries.FIND_WITH_FIRST_LETTER)
    List<VehicleType> findByFirstLetter(String letter);

    @Query(VehicleType.Queries.FIND_CONTAINING)
    List<VehicleType> findContaining(String keyword);
}
