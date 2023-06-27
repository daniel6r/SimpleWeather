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


    private String description;
    private BigDecimal temp;
    private String country;
    @JsonProperty("name")
    private String city;

    @JsonProperty("weather")
    private void unpackDescriptionFromNestedObject(Map<String, String>[] weather){
        this.description = weather[0].get("description");
    }

    @JsonProperty("main")
    private void unpackTempFromNestedObject(Map<String, String> main){
        this.temp = BigDecimal.valueOf(Double.parseDouble(main.get("temp")));
    }

    @JsonProperty("sys")
    private void unpackCountryFromNestedObject(Map<String, String> sys){
        this.country = sys.get("country");
    }




}
