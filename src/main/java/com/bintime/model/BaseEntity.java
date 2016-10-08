package com.bintime.model;

/**
 * Base class for all business entities
 *
 * @author Krukovskiy Arthur
 *
 */
public class BaseEntity {
    /**
     * Unique entity identifier
     */
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
