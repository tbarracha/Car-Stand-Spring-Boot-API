package pt.Dealership.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import pt.Dealership.Models.Color;
import pt.Dealership.Models.VehicleComponents.*;
import pt.Dealership.Models.Vehicles.Car;
import pt.Dealership.Models.Vehicles.Vehicle;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, String> {
    @Query
    Optional<T> findByVin(String vin);

    @Query
    Page<T> findByBrand(VehicleBrand brand, Pageable pageable);

    @Query
    Page<T> findByModel(VehicleModel model, Pageable pageable);

    @Query
    Page<T> findByStatus(VehicleStatus status, Pageable pageable);

    @Query
    Page<T> findByCondition(VehicleCondition condition, Pageable pageable);

    @Query
    Page<T> findByLicensePlate(LicensePlate licensePlate, Pageable pageable);

    @Query
    Page<T> findByColor(Color color, Pageable pageable);

    @Query
    Page<T> findByTransactionId(String transactionId, Pageable pageable);

    @Query
    Page<T> findByBuyerId(String buyerId, Pageable pageable);
}
