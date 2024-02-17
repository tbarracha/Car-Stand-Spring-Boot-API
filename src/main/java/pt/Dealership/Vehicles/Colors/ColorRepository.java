package pt.Dealership.Vehicles.Colors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query(Color.Queries.FIND_BY_NAME)
    Optional<Color> findByName(String name);

    @Query(Color.Queries.FIND_WITH_FIRST_LETTER)
    List<Color> findByFirstLetter(String letter);

    @Query(Color.Queries.FIND_CONTAINING)
    List<Color> findContaining(String keyword);

    @Query(Color.Queries.FIND_BY_HEXADECIMAL)
    Optional<Color> findByHexadecimal(String hexadecimal);
}
