package com.bintime.service;

import com.bintime.model.Line;

import java.util.List;

/**
 * Entry point to perform operations over {@link com.bintime.model.Line} entities
 *
 * @author Krukovskiy Arthur
 *
 */
public interface LineService {

    /**
     * Saves list of lines after pre-parsing and grouping identical strings
     *
     * @param lines
     * @return
     */
    List<Line> saveLine(String[] lines);

    /**
     * Returns numbers of lines from store
     *
     * @return
     */
    int getNumberOfLines();
}
