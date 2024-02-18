package pt.Common.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class LongIdNamedEntity<T> extends NamedEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public LongIdNamedEntity() {
        super();
    }

    public LongIdNamedEntity(String name) {
        super(name);
    }

    public Long getId() {
        return id;
    }
}
