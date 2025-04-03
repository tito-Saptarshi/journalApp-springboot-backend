package com.journal.journalApp.service;

import com.journal.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apikey;

    private  static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    private static final String apiKey = "4b53a35d8110d64e1e49932f42491a5f";

    public WeatherResponse getWeather (String city){
        String finalApi = API.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
//        above null represents header (currently has no header).
//        restTemplate -> code to hit-request like an API

//        json to java obj = deserialization

        WeatherResponse body = response.getBody();
        return body;

    }
}
