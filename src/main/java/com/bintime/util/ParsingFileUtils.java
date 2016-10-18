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
import java.util.List;

/**
 * Contains utility functions of parsing files
 *
 * @author Krukovskiy Arthur
 *
 */
public class ParsingFileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParsingFileUtils.class);

    public static List<Runnable> getTasks(List<MultipartFile> files, List<String> allLines) {
        List<Runnable> gettingTasks = new ArrayList<>();

        for (MultipartFile file : files) {
            if (file.getSize() == 0) {continue;}
            gettingTasks.add(() -> parseFile(file, allLines));
        }
        return gettingTasks;
    }

    public static List<String> parseFile(MultipartFile file, List<String> linesFromFile) {
        LOGGER.info("ParsingFileUtils.parseFile: Thread name: {}, file:{}", Thread.currentThread().getName(), file.getOriginalFilename());

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(file.getBytes()), Charsets.UTF_8))) {
            String temp = null;

            while ((temp = reader.readLine()) != null) {
                if (!temp.isEmpty()) {
                    linesFromFile.add(temp);
                }
            }
        } catch (IOException e) {
            LOGGER.error("ParsingFilesUtils.parseFile: {}", e);
        }
        return linesFromFile;
    }
}
