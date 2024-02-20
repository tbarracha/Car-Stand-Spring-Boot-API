package pt.Dealership.Models.Dealerships;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


}
