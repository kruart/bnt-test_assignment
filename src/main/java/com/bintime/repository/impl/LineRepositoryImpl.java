package com.bintime.repository.impl;

import com.bintime.model.Line;
import com.bintime.repository.LineRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Default implementation of the {@link LineRepository}
 *
 * @author Krukovskiy Arthur
 *
 */
@Repository
public class LineRepositoryImpl implements LineRepository {
    /**
     * Internal list of lines
     */
    private List<Line> linesStore;

    public LineRepositoryImpl() {
        linesStore = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public List<Line> saveLine(String[] lines) {
        for (String newLine : lines) {

            Optional<Line> first = linesStore.stream()
                    .filter(line -> line.getValue().equals(newLine))
                    .findFirst();

            if (first.isPresent()) {
                first.get().setCount(first.get().getCount() + 1);
            } else {
                linesStore.add(new Line(newLine));
            }
        }

        return linesStore;
    }

    @Override
    public int getNumberOfLines() {
        return linesStore.size();
    }
}
