package com.bintime.repository;

import com.bintime.model.Line;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Base class for testing all LineRepository implementations
 *
 * @author Krukovskiy Arthur
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractLineRepositoryTest {

    @Autowired
    private LineRepository repository;

    @Test
    public void testSaveLine() throws Exception {
        List<Line> linesAfterParsing = repository.saveLine(mockPopulate());

        assertEquals("xyz", linesAfterParsing.get(0).getValue());
        assertEquals(4, linesAfterParsing.get(0).getCount());

        assertEquals("yyy", linesAfterParsing.get(1).getValue());
        assertEquals(2, linesAfterParsing.get(1).getCount());
    }

    @Test
    public void testGetNumberOfLines() throws Exception {
        repository.saveLine(mockPopulate());
        assertEquals(3, repository.getNumberOfLines());
    }

    private List<String> mockPopulate() {
        return Arrays.asList("xyz", "xyz", "yyy", "xyz", "yyy", "smile", "xyz");
    }
}