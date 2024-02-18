package pt.Dealership.Models.Vehicles.VehicleConditions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleConditionRepository extends JpaRepository<VehicleCondition, Long> {
    @Query(VehicleCondition.Queries.FIND_BY_NAME)
    Optional<VehicleCondition> findByName(String name);

    @Query(VehicleCondition.Queries.FIND_WITH_FIRST_LETTER)
    List<VehicleCondition> findByFirstLetter(String letter);

    @Query(VehicleCondition.Queries.FIND_CONTAINING)
    List<VehicleCondition> findContaining(String keyword);
}
