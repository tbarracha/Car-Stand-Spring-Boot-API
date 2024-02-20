package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.Vehicles.Car;

import java.util.List;

public interface CarRepository extends VehicleRepository<Car> {
    @Query
    List<Car> findBySeatCount(int seatCount);

    @Query
    List<Car> findByDoorCount(int doorCount);
}
