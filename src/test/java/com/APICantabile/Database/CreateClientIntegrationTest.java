package com.APICantabile.Database;

import com.APICantabile.Database.Entities.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateClientIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createClient(){
        ResponseEntity<Hospital> responseEntity = restTemplate.postForEntity("/testdb/hospitals", new Hospital(4000,"Test Hospital 3","Chennai",3.9), Hospital.class);

        Hospital hosp = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Test Hospital 3", hosp.getName());
    }
}
