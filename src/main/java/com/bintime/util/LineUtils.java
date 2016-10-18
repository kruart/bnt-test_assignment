package com.bintime.util;

import com.bintime.model.Line;
import com.bintime.to.LineDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contains utility functions for {@link Line} objects
 *
 * @author Krukovskiy Arthur
 *
 */
public class LineUtils {


    /**
     * Transform collections of string to collections of unique Line objects
     *
     * @param lines
     */
    public static List<Line> getUniqueLines(List<String> lines) {
        Map<String, Integer> countUniqueStrings = new HashMap<>();

        for (String newLine : lines) {
            countUniqueStrings.merge(newLine, 1, (a, b) -> a + b);
        }

        return countUniqueStrings.entrySet()
                .stream()
                .map(stringIntegerEntry -> new Line(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Transform {@link Line} collection to {@link LineDTO} collection
     *
     * @param lines
     * @return
     */
    public static List<LineDTO> transform(List<Line> lines) {
        List<LineDTO> newLines = new ArrayList<>();

        for (Line line : lines) {
            newLines.add(new LineDTO(line.getValue(), line.getCount()));
        }
        return newLines;
    }
}
