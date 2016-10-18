package com.bintime.repository.mock;

import com.bintime.model.Line;
import com.bintime.model.UploadRequest;
import com.bintime.repository.LineRepository;
import com.bintime.util.LineUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        linesStore = mockPopulate();
    }

    @Override
    public Integer saveLine(List<String> lines) {
        linesStore = Collections.synchronizedList(mockPopulate());

        UploadRequest req = new UploadRequest(2);

        List<Line> uniqueLines = LineUtils.getUniqueLines(lines);

        for (Line line : uniqueLines) {
            line.setRequest(req);
            linesStore.add(line);
        }
        return req.getId();
    }


    @Override
    public List<Line> getLinesByRequestId(int requestId) {
        List<Line> lines = new ArrayList<>();

        return linesStore.stream()
                .filter(line -> line.getRequest().getId() == requestId)
                .collect(Collectors.toList());
    }

    public List<Line> mockPopulate(){
        List<Line> mockLines = new ArrayList<>();
        mockLines.add(new Line("When you want to take a nap, the violin will wake you up.", 2, new UploadRequest(1)));
        mockLines.add(new Line("You want to help me, Alan? Find a gun and shoot me in the eye.", 3, new UploadRequest(1)));

        return mockLines;
    }
}
