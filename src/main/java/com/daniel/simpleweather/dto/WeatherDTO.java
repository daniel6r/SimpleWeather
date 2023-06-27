package com.daniel.simpleweather.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherDTO {

    private String main;
    private String description;
    private BigDecimal temp;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private String pressure;
    private String humidity;
    private String wind_speed;
    private String country;
    @JsonProperty("name")
    private String city;

    @JsonProperty("weather")
    private void unpackWeatherDetailsNestedObject(Map<String, String>[] weather) {
        this.main = weather[0].get("main");
        this.description = weather[0].get("description");
    }

//    @JsonProperty("weather")
//    private void unpackDescriptionFromNestedObject(Map<String, String>[] weather) {
//        this.description = weather[0].get("description");
//    }

    @JsonProperty("main")
    private void unpackTempDetailsFromNestedObject(Map<String, String> main) {
        this.temp = BigDecimal.valueOf(Double.parseDouble(main.get("temp")));
        this.temp_min = BigDecimal.valueOf(Double.parseDouble(main.get("temp_min")));
        this.temp_max = BigDecimal.valueOf(Double.parseDouble(main.get("temp_max")));
        this.pressure = main.get("pressure");
        this.humidity = main.get("humidity");
    }


    @JsonProperty("wind")
    private void unpackWindSpeedFromNestedObject(Map<String, String> wind) {
        this.wind_speed = wind.get("speed");
    }


    @JsonProperty("sys")
    private void unpackCountryFromNestedObject(Map<String, String> sys) {
        this.country = sys.get("country");
    }
}
