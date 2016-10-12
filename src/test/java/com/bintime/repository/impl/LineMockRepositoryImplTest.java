package com.bintime.repository.impl;

import com.bintime.repository.AbstractLineRepositoryTest;
import com.bintime.repository.mock.LineMockRepositoryImpl;
import org.springframework.test.context.ContextConfiguration;

/**
 * Contain unit-tests for {@link LineMockRepositoryImpl}
 *
 * @author Krukovskiy Arthur
 *
 */
@ContextConfiguration({
        "classpath:spring/spring-mock.xml"
})
public class LineMockRepositoryImplTest extends AbstractLineRepositoryTest {
}