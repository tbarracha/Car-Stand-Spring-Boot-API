package pt.Dealership.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.LicensePlate;

import java.util.List;
import java.util.Optional;

public interface LicensePlateRepository extends JpaRepository<LicensePlate, Long> {
    @Query("SELECT entity FROM LicensePlate entity WHERE LOWER(entity.license) = LOWER(:license)")
    Optional<LicensePlate> findByLicense(String license);

    @Query
    Page<LicensePlate> findByVin(String vin, Pageable pageable);

    @Query
    Page<LicensePlate> findByCountry(String country, Pageable pageable);
}
