package com.bintime.repository.mock;

import com.bintime.model.Line;
import com.bintime.repository.LineRepository;
import com.bintime.util.LineUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Default mock implementation of the {@link LineRepository}
 *
 * @author Krukovskiy Arthur
 *
 */
@Repository
public class LineMockRepositoryImpl implements LineRepository {
    /**
     * Internal list of lines
     */
    private List<Line> linesStore;

    public LineMockRepositoryImpl() {
        linesStore = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public List<Line> saveLine(List<String> lines) {
        linesStore = LineUtils.getUniqueLines(lines);
        return linesStore;
    }

    @Override
    public int getNumberOfLines() {
        return linesStore.size();
    }
}
