package com.daniel.simpleweather.service;

import com.daniel.simpleweather.dto.WeatherDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public WeatherDTO checkWeather(String lon, String lat) throws JsonProcessingException {

        Map<String, String> params = new HashMap<>();
        params.put("lon", lon);
        params.put("lat", lat);
        params.put("appid", apiKey);

        ResponseEntity<String> entity = restTemplate.getForEntity(apiUrl + "?lon={lon}&lat={lat}&appid={appid}",
                                String.class, params);

        ObjectMapper objectMapper = new ObjectMapper();

        WeatherDTO weatherDTO = objectMapper.readValue(entity.getBody(), WeatherDTO.class);

        return weatherDTO;
    }

}
