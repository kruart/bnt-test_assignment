package com.bintime.repository.impl;

import com.bintime.model.Line;
import com.bintime.repository.LineRepository;
import com.bintime.util.LineUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * Jpa implementation of the {@link LineRepository}
 *
 * @author Krukovskiy Arthur
 *
 */
@Repository
@Transactional(readOnly = true)
public class LineJpaRepositoryImpl implements LineRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Line> saveLine(List<String> lines) {

        List<Line> uniqueLines = LineUtils.getUniqueLines(lines);

        for (Line uniqueLine : uniqueLines) {
            em.persist(uniqueLine);
        }
        return uniqueLines;
    }

    @Override
    public int getNumberOfLines() {
        Query query = em.createNativeQuery("SELECT count(*) FROM line");
        BigInteger singleResult = (BigInteger) query.getSingleResult();
        return singleResult.intValue();
    }
}
