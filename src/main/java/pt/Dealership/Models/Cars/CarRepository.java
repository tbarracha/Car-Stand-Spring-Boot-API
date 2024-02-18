package pt.Dealership.Models.Cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Models.Vehicles.VehicleRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends VehicleRepository<Car> {
    @Query
    List<Car> findBySeatCount(int seatCount);

    @Query
    List<Car> findByDoorCount(int doorCount);
}
