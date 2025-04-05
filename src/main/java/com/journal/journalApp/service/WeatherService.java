package com.journal.journalApp.service;

import com.journal.journalApp.api.response.WeatherResponse;
import com.journal.journalApp.cache.AppCache;
import com.journal.journalApp.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;

//    private  static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

//    private static final String apiKey = "4b53a35d8110d64e1e49932f42491a5f";

    public WeatherResponse getWeather (String city){
//        String finalApi = appCache.APP_CACHE.replace("CITY", city).replace("API_KEY", apiKey);
        String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
//        above null represents header (currently has no header).
//        restTemplate -> code to hit-request like an API

//        json to java obj = deserialization

        WeatherResponse body = response.getBody();
        return body;

    }
}
