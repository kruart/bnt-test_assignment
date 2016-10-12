package com.bintime.repository.impl;

import com.bintime.repository.AbstractLineRepositoryTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

/**
 * Contain unit-tests for {@link LineJpaRepositoryImpl}
 *
 * @author Krukovskiy Arthur
 *
 */
@ContextConfiguration({
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class LineJpaRepositoryImplTest extends AbstractLineRepositoryTest {}