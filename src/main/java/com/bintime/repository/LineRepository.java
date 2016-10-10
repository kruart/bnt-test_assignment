package com.bintime.repository;

import com.bintime.model.Line;

import java.util.List;

/**
 * Entry point to perform operations over {@link com.bintime.model.Line} entities
 *
 * @author Krukovskiy Arthur
 *
 */
public interface LineRepository {

    /**
     * Saves list of lines after pre-parsing and grouping identical strings
     *
     * @param lines
     * @return
     */
    List<Line> saveLine(List<String> lines);

    /**
     * Returns numbers of lines from store
     *
     * @return
     */
    int getNumberOfLines();
}
