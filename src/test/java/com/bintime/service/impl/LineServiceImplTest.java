package com.bintime.service.impl;

import com.bintime.model.Line;
import com.bintime.service.LineService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link LineServiceImpl}
 *
 * @author Krukovskiy Arthur
 *
 */
public class LineServiceImplTest {
    private LineService service;

    @Before
    public void setup() {
        service = new LineServiceImpl();
    }

    @Test
    public void testSaveLine() throws Exception {
        List<Line> linesAfterParsing = service.saveLine(populate());

        assertEquals("xyz", linesAfterParsing.get(0).getValue());
        assertEquals(2, linesAfterParsing.get(0).getCount());

        assertEquals("yyy", linesAfterParsing.get(1).getValue());
        assertEquals(1, linesAfterParsing.get(1).getCount());
    }

    @Test
    public void testGetNumberOfLines() throws Exception {
        assertEquals(0, service.getNumberOfLines());
        service.saveLine(populate());
        assertEquals(2, service.getNumberOfLines());
    }

    private List<Line> populate() {
        Line line1 = new Line("xyz");
        Line line2 = new Line("xyz");
        Line line3 = new Line("yyy");

        return Arrays.asList(line1, line2, line3);
    }
}