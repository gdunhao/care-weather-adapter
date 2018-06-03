package com.care.weather.adapter.server.weather;

import com.care.model.weather.WeatherRequest;
import com.care.model.weather.WeatherResponse;
import com.care.weather.adapter.server.configuration.WeatherAdapterEndpointPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WeatherAdapterEndpointPath.WEATHER_ADAPTER_WEATHER_ENDPOINT)
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping
    WeatherResponse fetchWeather(@RequestParam String city, @RequestParam String country) {

        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setCity(city);
        weatherRequest.setCountry(country);

        return weatherService.fetchWeather(weatherRequest);
    }
}