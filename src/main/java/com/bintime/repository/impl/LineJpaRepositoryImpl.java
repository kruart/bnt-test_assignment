package com.bintime.repository.impl;

import com.bintime.model.Line;
import com.bintime.model.UploadRequest;
import com.bintime.repository.LineRepository;
import com.bintime.util.LineUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public Integer saveLine(List<String> lines) {

        UploadRequest req = new UploadRequest();
        em.persist(req);

        List<Line> uniqueLines = LineUtils.getUniqueLines(lines);

        for (Line uniqueLine : uniqueLines) {
            uniqueLine.setRequest(req);
            em.persist(uniqueLine);
        }
        return req.getId();
    }

    @Override
    public List<Line> getLinesByRequestId(int requestId) {
        return em.createNamedQuery(Line.GET_LINES_BY_REQUEST_ID, Line.class).setParameter("requestId", requestId).getResultList();
    }
}
