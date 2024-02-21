package pt.Dealership.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.VehicleComponents.LicensePlate;
import pt.Dealership.Models.VehicleComponents.VehicleBrand;
import pt.Dealership.Models.VehicleComponents.VehicleCondition;
import pt.Dealership.Models.VehicleComponents.VehicleStatus;
import pt.Dealership.Models.Vehicles.Car;

import java.util.List;

public interface CarRepository extends VehicleRepository<Car> {
    @Query
    Page<Car> findBySeatCount(int seatCount, Pageable pageable);

    @Query
    Page<Car> findByDoorCount(int doorCount, Pageable pageable);
}
