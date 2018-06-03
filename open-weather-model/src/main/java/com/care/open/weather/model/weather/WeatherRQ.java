package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherRQ {

    private String city;
    private String country;
}