package com.bintime.model;

/**
 * Contains value of the line/string and the number of occurrences
 * of the string in all files that were transferred during one particular request
 *
 * @author Krukovskiy Arthur
 *
 */
public class Line {

    private String value;

    private int count;

    public Line(String value) {
        this.value = value;
        this.count = 0;
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
