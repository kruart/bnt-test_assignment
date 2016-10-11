package com.bintime.web.rest;

import com.bintime.model.Line;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Contain unit-tests for {@link LineRestController}
 */
@WebAppConfiguration
@ContextConfiguration({
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class LineRestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    LineRestController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testUploadFile() throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("test/filetest1.txt"));

        MockMultipartFile firstFile = new MockMultipartFile("file", "filename.txt", "text/plain", bytes);
        MockMultipartFile secondFile = new MockMultipartFile("file", "other-file-name.pdf", "text/plain", bytes);
        MockMultipartFile thirdFile = new MockMultipartFile("file", "smile.txt", "text/plain", bytes);
        MockMultipartFile fourthFile = new MockMultipartFile("file", "kote.txt", "text/plain", bytes);
        MockMultipartFile fifthFile = new MockMultipartFile("file", "data.txt", "text/plain", bytes);

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/rest/multipleSave")
                .file(firstFile).file(secondFile).file(thirdFile).file(fourthFile).file(fifthFile))
                .andExpect(flash().attributeCount(1)) //RedirectAttributes
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/rest/result"));
    }

    @Test
    public void resultOfParsing() throws Exception {
        //solution to the problem of "content type not set ==>
        // http://stackoverflow.com/questions/37448548/java-lang-assertionerror-content-type-not-set-even-after-setting-content-type-a"
        mockMvc.perform(get("/rest/result")
                .contentType(MediaType.APPLICATION_JSON)
                .flashAttr("flashAttrs", Arrays.asList(new Line("open"), new Line("close"))))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
