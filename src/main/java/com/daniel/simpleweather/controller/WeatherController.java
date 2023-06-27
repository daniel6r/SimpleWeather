package com.daniel.simpleweather.controller;

import com.daniel.simpleweather.dto.WeatherDTO;
import com.daniel.simpleweather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public WeatherDTO getWeather(@RequestParam String lon, @RequestParam String lat) throws JsonProcessingException {
        return weatherService.checkWeather(lon, lat);
    }
}
