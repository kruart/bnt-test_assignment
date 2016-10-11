package com.bintime.util;

import org.apache.commons.io.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Contains utility functions of parsing files
 *
 * @author Krukovskiy Arthur
 *
 */
public class ParsingFileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParsingFileUtils.class);
    private static final int NTHD = 3;

    public static List<String> parallelParseFiles(List<MultipartFile> files) {
        List<String> allLines = Collections.synchronizedList(new ArrayList<>());
        List<Runnable> tasks = getTasks(files, allLines);   //each file is a one specific task

        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool(NTHD);
            forkJoinPool.submit(
                    () -> tasks.stream().parallel().forEach(Runnable::run)
            ).get();
            forkJoinPool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return allLines;
    }

    private static List<Runnable> getTasks(List<MultipartFile> files, List<String> allLines) {
        List<Runnable> gettingTasks = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.getSize() == 0) {continue;}
            gettingTasks.add(() -> parseFile(file, allLines));
        }
        return gettingTasks;
    }

    private static List<String> parseFile(MultipartFile file, List<String> linesFromFile) {
        LOGGER.info("ParsingFileUtils.parseFile: Thread name: {}, file:{}", Thread.currentThread().getName(), file.getOriginalFilename());

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(file.getBytes()), Charsets.UTF_8))) {
            String temp = null;

            while ((temp = reader.readLine()) != null) {
                if (!temp.isEmpty()) {
                    linesFromFile.add(temp);
                }
            }
        } catch (IOException e) {
            LOGGER.error("ParsingFilesUtils.parsing: {}", e);
        }
        return linesFromFile;
    }
}
