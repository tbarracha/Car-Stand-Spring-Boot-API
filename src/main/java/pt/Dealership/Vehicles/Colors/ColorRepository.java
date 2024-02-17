package pt.Dealership.Vehicles.Colors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query
    Optional<Color> findByName(String name);

    @Query
    Optional<Color> findByHexadecimal(String hexadecimal);
}
