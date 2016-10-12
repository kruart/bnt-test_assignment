package com.bintime.to;

/**
 * Represents transformation engine to convert business entities
 * into DTO objects
 *
 * @author Krukovskiy Arthur
 *
 */
public class LineDTO {

    private String value;

    private int count;

    public LineDTO() {
    }

    public LineDTO(String value, int count) {
        this.value = value;
        this.count = count;
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

    public void setCount(int count) {
        this.count = count;
    }
}
