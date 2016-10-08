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

    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Line(String value, Integer count) {
        this.value = value;
        this.count = count;
    }
}
