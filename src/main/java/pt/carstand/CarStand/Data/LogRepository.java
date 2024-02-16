package pt.carstand.CarStand.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.carstand.CarStand.Models.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
