package pt.Dealership.Models.Vehicles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlate;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleCondition;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatus;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, String> {
    @Query
    Optional<T> findByVin(String vin);

    @Query
    List<Vehicle> findByLicensePlate(LicensePlate licensePlate);
    @Query
    List<Vehicle> findByLicensePlateName(String licensePlateName);

    /*
    @Query("SELECT v FROM Vehicle v WHERE v.licensePlate.name = :licensePlate")
    List<Vehicle> findByLicensePlate(String licensePlate);

    @Query("SELECT v FROM Vehicle v WHERE v.brand.id = :brandId")
    List<Vehicle> findByBrandId(Long brandId);

    @Query("SELECT v FROM Vehicle v WHERE v.brand.name = :brandName")
    List<Vehicle> findByBrandName(String brandName);

    @Query("SELECT v FROM Vehicle v WHERE v.model.id = :modelId")
    List<Vehicle> findByModelId(Long modelId);
    @Query("SELECT v FROM Vehicle v WHERE v.model.name = :modelName")
    List<Vehicle> findByModelName(String modelName);

    @Query("SELECT v FROM Vehicle v WHERE v.color.id = :colorId")
    List<Vehicle> findByColorId(Long colorId);

    @Query("SELECT v FROM Vehicle v WHERE v.color.hexadecimal = :colorHexadecimal")
    List<Vehicle> findByColorHexadecimal(String colorHexadecimal);

    @Query("SELECT v FROM Vehicle v WHERE v.yearOfAssembly = :yearOfAssembly")
    List<Vehicle> findByYearOfAssembly(Integer yearOfAssembly);

    @Query("SELECT v FROM Vehicle v WHERE v.status = :status")
    List<Vehicle> findByStatus(VehicleStatus status);

    @Query("SELECT v FROM Vehicle v WHERE v.condition = :condition")
    List<Vehicle> findByCondition(VehicleCondition condition);

    @Query("SELECT v FROM Vehicle v WHERE v.price = :price")
    List<Vehicle> findByPrice(Double price);

    @Query("SELECT v FROM Vehicle v WHERE v.price <= :maxPrice")
    List<Vehicle> findByPriceLessThanEqual(Double maxPrice);

    @Query("SELECT v FROM Vehicle v WHERE v.price >= :minPrice AND v.price <= :maxPrice")
    List<Vehicle> findByPriceBetween(Double minPrice, Double maxPrice);

     */
}
