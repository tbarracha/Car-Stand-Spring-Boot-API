package pt.Dealership.Users.AppUsers;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.base.interfaces.IIdentifiable;
import pt.Dealership.base.interfaces.INameable;

@Entity
public class AppUser extends RepresentationModel<AppUser> implements IIdentifiable<Long>, INameable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;
    String phoneNumber;

    long sellerId;
    long buyerId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return null;
    }
}
