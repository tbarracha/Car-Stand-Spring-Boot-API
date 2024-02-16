package pt.carstand.CarStand.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Log extends RepresentationModel<Log> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String message;

    public Log() {
    }

    public Log(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
