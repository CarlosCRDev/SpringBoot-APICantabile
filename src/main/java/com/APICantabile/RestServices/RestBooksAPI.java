package com.APICantabile.RestServices;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
public class RestBooksAPI {
    static RestTemplate restTemplate;

    public RestBooksAPI() {
        restTemplate = new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RestBooksAPI.class, args);
        try {
            JSONObject books = getEntity();
            System.out.println(books);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get entity
     * @throws JSONException
     */
    public static JSONObject getEntity()throws Exception{
        JSONObject books = new JSONObject();
        String getUrl = "https://www.googleapis.com/books/v1/volumes?q=isbn:07475326999";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Map> bookList = restTemplate.exchange(getUrl, HttpMethod.GET,entity, Map.class);

        if(bookList.getStatusCode() == HttpStatus.OK) {
            books = new JSONObject(bookList.getBody());
        }
        return books;
    }
}