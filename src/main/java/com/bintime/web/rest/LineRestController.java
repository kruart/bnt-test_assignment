package com.bintime.web.rest;

import com.bintime.model.Line;
import com.bintime.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Spring REST Controller that handles requests for specific URLs
 *
 * @author Krukovskiy Arthur
 *
 */

@RestController
@RequestMapping("rest")
public class LineRestController {

    @Autowired
    private LineRepository repository;

    /**
     * Uploads multiple files from html-form.
     *
     * @throws Exception
     */
    @RequestMapping(value = "/multipleSave", method = RequestMethod.POST)
    public void uploadFile(@RequestParam(value = "file", required = false) List<MultipartFile> files, HttpServletResponse response) throws IOException {
        response.sendRedirect("/rest/result");
    }

    /**
     * returns the result of parsing as json
     *
     * @return
     */
    @RequestMapping(value = "/result", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Line> resultOfParsing() {
        return Arrays.asList(new Line("open"), new Line("close"));
//        return "Hello World";
    }
}
