package pt.Dealership.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.Dealership.Models.Color;

import java.util.List;
import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("SELECT entity FROM Color entity WHERE LOWER(entity.name) = LOWER(:name)")
    Optional<Color> findByName(String name);

    @Query("SELECT entity FROM Color entity WHERE LOWER(entity.hexadecimal) = LOWER(:hexadecimal)")
    Optional<Color> findByHexadecimal(String hexadecimal);
}
