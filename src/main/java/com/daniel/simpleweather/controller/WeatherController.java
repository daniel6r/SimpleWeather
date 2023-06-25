package com.daniel.simpleweather.controller;

import com.daniel.simpleweather.service.WeatherService;
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
    public String getWeather(@RequestParam String lon, @RequestParam String lat){
        return weatherService.checkWeather(lon, lat);
    }
}
