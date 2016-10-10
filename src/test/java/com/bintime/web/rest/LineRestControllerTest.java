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
        "classpath:spring/spring-context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class LineRestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(new LineRestController()).build();
    }

    @Test
    public void testUploadFile() throws Exception {

        MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        MockMultipartFile secondFile = new MockMultipartFile("data", "other-file-name.data", "text/plain", "some other type".getBytes());

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/rest/multipleSave")
                .file(firstFile).file(secondFile))
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
