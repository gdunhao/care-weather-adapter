package com.care.open.weather.flow.weather.transformers;

import com.care.model.weather.*;
import com.care.open.weather.model.weather.WeatherRQ;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

@Service
public class WeatherRequestTransformer {

  @Transformer
  WeatherRQ createWeatherResponse(WeatherRequest weatherRequest) {

    return convertOpenWeatherRSToWeather(weatherRequest);
  }

  private WeatherRQ convertOpenWeatherRSToWeather(WeatherRequest weatherRequest) {
    WeatherRQ weatherRQ = new WeatherRQ();
    weatherRQ.setCity(weatherRequest.getCity());
    weatherRQ.setCountry(weatherRequest.getCountry());

    return weatherRQ;
  }
}