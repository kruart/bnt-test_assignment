package com.bintime.util;

import com.bintime.model.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Line> uniqueLines = new ArrayList<>();

        for (String newLine : lines) {

            Optional<Line> first = uniqueLines.stream()
                    .filter(line -> line.getValue().equals(newLine))
                    .findFirst();

            if (first.isPresent()) {
                first.get().setCount(first.get().getCount() + 1);
            } else {
                uniqueLines.add(new Line(newLine));
            }
        }

        return uniqueLines;
    }
}
