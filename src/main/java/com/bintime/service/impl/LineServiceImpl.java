package com.bintime.service.impl;

import com.bintime.repository.LineRepository;
import com.bintime.service.LineService;
import com.bintime.to.LineDTO;
import com.bintime.util.LineUtils;
import com.bintime.util.ParsingFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Default implementation of the {@link LineService}
 *
 * @author Krukovskiy Arthur
 *
 */
@Service()
public class LineServiceImpl implements LineService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParsingFileUtils.class);

    @Autowired
    private LineRepository repository;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Override
    public Integer saveLine(List<MultipartFile> files) {
        List<String> allLines = Collections.synchronizedList(new ArrayList<>());

        try {
            for (MultipartFile file : files) {
                taskExecutor.submit(
                        (Runnable) () -> ParsingFileUtils.parseFile(file, allLines)
                ).get();
            }
//            taskExecutor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("ParsingFilesUtils.parallelParseFiles: {}", e);
        }
        return repository.saveLine(allLines);
    }

    @Override
    public List<LineDTO> getLinesByRequestId(int requestId) {
        return LineUtils.transform(repository.getLinesByRequestId(requestId));
    }
}
