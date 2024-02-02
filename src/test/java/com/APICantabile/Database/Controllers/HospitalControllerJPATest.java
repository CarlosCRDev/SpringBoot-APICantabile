package com.APICantabile.Database.Controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HospitalControllerJPATest {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void retrieveTest_ok()throws Exception{
        mockMvc.perform(get("/testdb/hospitals")).andDo(print())
                .andExpect(status().isOk());

    }

    //fuciona pero hay que agregar el método post para guardar información
    @Test
    public void retrieveTest_ok2()throws Exception{
        mockMvc.perform(get("/testdb/hospitals/1000")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Hospital"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.raiting").value(3.9))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Chennai"));
    }


}