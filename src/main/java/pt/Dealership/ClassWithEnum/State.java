package pt.Dealership.ClassWithEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String name;
    public StateEnum stateEnum;

    public State() {

    }

    public State(String name, StateEnum stateEnum) {
        this.name = name;
        this.stateEnum = stateEnum;
    }
}
