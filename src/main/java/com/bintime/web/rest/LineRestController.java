package com.bintime.web.rest;

import com.bintime.model.Line;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/result", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Line> resultOfParsing() {
        return Arrays.asList(new Line("open"), new Line("close"));
//        return "Hello World";
    }
}
