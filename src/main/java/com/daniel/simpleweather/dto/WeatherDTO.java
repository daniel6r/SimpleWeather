package com.daniel.simpleweather.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WeatherDTO {

    String main;
    String description;
    BigDecimal temp;
    String country;
    String city;


}
