package com.bintime.web.rest;

import com.bintime.service.LineService;
import com.bintime.to.LineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

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
    private LineService lineService;

    /**
     * Uploads multiple files from html-form.
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "/multipleSave", method = RequestMethod.POST)
    public RedirectView uploadFile(@RequestParam(value = "file") List<MultipartFile> files) {

        int index = lineService.saveLine(files);

        return new RedirectView("/rest/result/" + index);
    }

    /**
     * Returns the result of parsing as json
     *
     * @param requestId
     * @return
     */
    @RequestMapping(value = "/result/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LineDTO> resultOfParsing(@PathVariable("id") int requestId) {
        return lineService.getLinesByRequestId(requestId);
    }
}
