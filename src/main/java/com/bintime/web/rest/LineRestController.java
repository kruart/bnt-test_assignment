package com.bintime.web.rest;

import com.bintime.model.Line;
import com.bintime.repository.LineRepository;
import com.bintime.util.ParsingFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    private LineRepository repository;

    /**
     * Uploads multiple files from html-form.
     *
     * @param files
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/multipleSave", method = RequestMethod.POST)
    public RedirectView uploadFile(@RequestParam(value = "file") List<MultipartFile> files, RedirectAttributes attributes) {

        List<Line> lines = repository.saveLine(ParsingFileUtils.parsing(files));

        attributes.addFlashAttribute("flashAttrs", lines);

        return new RedirectView("/rest/result", true);
    }

    /**
     * Returns the result of parsing as json
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/result", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object resultOfParsing(Model model) {
        return model.asMap().get("flashAttrs");
    }
}
