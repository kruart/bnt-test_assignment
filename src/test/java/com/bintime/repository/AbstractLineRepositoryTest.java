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
        int indexOfRequest = repository.saveLine(mockPopulate());

        assertEquals(2, indexOfRequest);
    }

    @Test
    public void testGetLinesByRequestId() throws Exception {
        List<Line> linesByRequestId = repository.getLinesByRequestId(1);
        assertEquals(2, linesByRequestId.size());
    }

    private List<String> mockPopulate() {
        return Arrays.asList("xyz", "xyz", "yyy", "xyz", "yyy", "smile", "xyz");
    }
}