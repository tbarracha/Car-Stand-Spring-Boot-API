package pt.Dealership.Vehicles.VehicleStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
    @Query(VehicleStatus.Queries.FIND_BY_NAME)
    Optional<VehicleStatus> findByName(String name);

    @Query(VehicleStatus.Queries.FIND_WITH_FIRST_LETTER)
    List<VehicleStatus> findByFirstLetter(String letter);

    @Query(VehicleStatus.Queries.FIND_CONTAINING)
    List<VehicleStatus> findContaining(String keyword);
}
