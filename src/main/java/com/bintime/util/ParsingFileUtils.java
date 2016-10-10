package com.bintime.util;

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

/**
 * Contains utility functions of parsing files
 *
 * @author Krukovskiy Arthur
 *
 */
public class ParsingFileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParsingFileUtils.class);

    public static List<String> parsing(List<MultipartFile> files) {
        List<String> lines = Collections.synchronizedList(new ArrayList<>());
        BufferedReader reader = null;

        try {
            for (MultipartFile file : files) {
                if (file.getSize() == 0) continue;

                byte[] fileBytes = file.getBytes();

                reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(fileBytes)));

                String temp = null;
                while ((temp = reader.readLine()) != null) {
                    lines.add(temp);
                }
            }
        } catch (IOException e) {
            LOGGER.error("ParsingFilesUtils.parsing: {}", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return lines;
    }
}
