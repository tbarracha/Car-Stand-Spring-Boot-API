package pt.Dealership.Models.Vehicles.LicensePlates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LicensePlateRepository extends JpaRepository<LicensePlate, Long> {
    @Query(LicensePlate.Queries.FIND_BY_NAME)
    Optional<LicensePlate> findByName(String name);

    @Query(LicensePlate.Queries.FIND_WITH_FIRST_LETTER)
    List<LicensePlate> findByFirstLetter(String letter);

    @Query(LicensePlate.Queries.FIND_CONTAINING)
    List<LicensePlate> findContaining(String keyword);
}
