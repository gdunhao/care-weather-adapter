package com.care.open.weather.flow.weather;

import com.care.model.weather.WeatherResponse;
import com.care.model.weather.WeatherRequest;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface WeatherGateway {

  @Gateway(requestChannel = WeatherConstants.FETCH_WEATHER_CHANNEL_NAME)
  WeatherResponse fetchWeather(WeatherRequest weatherRequest);
}