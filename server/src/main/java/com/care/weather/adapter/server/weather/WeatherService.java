package com.care.weather.adapter.server.weather;

import com.care.model.weather.WeatherRequest;
import com.care.model.weather.WeatherResponse;
import com.care.weather.adapter.flow.weather.WeatherGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    WeatherGateway weatherGateway;

    WeatherResponse fetchWeather(WeatherRequest weatherRequest) {

        return weatherGateway.fetchWeather(weatherRequest);
    }
}