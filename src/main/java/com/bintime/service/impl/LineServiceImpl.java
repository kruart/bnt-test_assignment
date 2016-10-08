package com.bintime.service.impl;

import com.bintime.model.Line;
import com.bintime.service.LineService;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of the {@link LineService}
 *
 * @author Krukovskiy Arthur
 *
 */
public class LineServiceImpl implements LineService {
    /**
     * Internal list of lines
     */
    private List<Line> linesStore;

    public LineServiceImpl() {
        linesStore = new ArrayList<>();
    }

    @Override
    public List<Line> saveLine(List<Line> lines) {
        for (Line newLine : lines) {

            if (!linesStore.contains(newLine)) {
                linesStore.add(newLine);
            }

            for (Line line : linesStore) {
                if (newLine.equals(line)) {
                    line.setCount(line.getCount() + 1);
                    break;
                }
            }
        }

        return linesStore;
    }

    @Override
    public int getNumberOfLines() {
        return linesStore.size();
    }
}
