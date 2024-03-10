package com.example.tulip.sample;

import com.example.tulip.controller.SampleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SampleController.class)
public class SampleTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSample() throws Exception{
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/sample"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Sample controller is working."));
    }
}
