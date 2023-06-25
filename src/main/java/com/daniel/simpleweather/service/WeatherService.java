package com.daniel.simpleweather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RestTemplate restTemplate;
    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.key}")
    private String apiKey;

    public String checkWeather(String lon, String lat){

        Map<String, String> params = new HashMap<>();
        params.put("lon", lon);
        params.put("lat", lat);
        params.put("appid", apiKey);

        ResponseEntity<String> entity = restTemplate.getForEntity(apiUrl + "?lon={lon}&lat={lat}&appid={appid}",
                                String.class, params);


        return entity.getBody();
    }

}
