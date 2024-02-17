package pt.Dealership.Vehicles.LicensePlates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LicensePlateRepository extends JpaRepository<LicensePlate, Long> {
    @Query
    Optional<LicensePlate> findByName(String name);
}
