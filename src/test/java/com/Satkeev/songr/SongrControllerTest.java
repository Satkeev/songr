package com.Satkeev.songr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


public class SongrControllerTest {

    private MockMvc mockMvc;
    @Test

    public void testHello() throws Exception {
        this.mockMvc 
                .perform(get("/hello"))
                .andExpect(content()
                        .string(containsString("Hello, World!")));
    }

    @Test
    public void testCapitalize() throws Exception {
        this.mockMvc
                .perform(get("/capitalize/My work"))
                .andExpect(content()
                        .string(containsString("MY WORK")));
    }
}