package com.bintime.model;

import javax.persistence.*;

/**
 * Contains value of the line/string and the number of occurrences
 * of the string in all files that were transferred during one particular request
 *
 * @author Krukovskiy Arthur
 *
 */
@NamedQuery(name = Line.GET_BY_REQUEST_ID, query = "SELECT m FROM Line m WHERE m.request.id=:requestId")
@Entity
@Table(name = "line")
public class Line extends BaseEntity{
    public static final String GET_BY_REQUEST_ID = "Line.getByRequestId";

    @Column(name = "value_of_line")
    private String value;

    @Column(name = "counter")
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    private UploadRequest request;

    public Line() {
        this.count = 1;
    }

    public Line(String value) {
        this.value = value;
        this.count = 1;
    }

    public Line(String value, int count, UploadRequest request) {
        this.value = value;
        this.count = count;
        this.request = request;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public UploadRequest getRequest() {
        return request;
    }

    public void setRequest(UploadRequest request) {
        this.request = request;
    }

    public Line(String value, Integer count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return value != null ? value.equals(line.value) : line.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
