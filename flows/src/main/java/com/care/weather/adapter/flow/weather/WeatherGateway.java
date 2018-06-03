package com.care.weather.adapter.flow.weather;

import com.care.model.weather.WeatherRequest;
import com.care.model.weather.WeatherResponse;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface WeatherGateway {

    @Gateway(requestChannel = WeatherConstants.WEATHER_CHANNEL_NAME)
    WeatherResponse fetchWeather(WeatherRequest weatherRequest);
}