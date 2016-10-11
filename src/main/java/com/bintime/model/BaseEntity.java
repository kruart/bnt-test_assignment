package com.bintime.model;

import javax.persistence.*;

/**
 * Base class for all business entities
 *
 * @author Krukovskiy Arthur
 *
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {
    /**
     * Unique entity identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
