package pt.carstand.CarStand.Models.AppUsers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Buyer extends RepresentationModel<Buyer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long appUserId;

    public Buyer(long id, long appUserId) {
        this.id = id;
        this.appUserId = appUserId;
    }

    public long getId() {
        return id;
    }

    public long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(long appUserId) {
        this.appUserId = appUserId;
    }
}
