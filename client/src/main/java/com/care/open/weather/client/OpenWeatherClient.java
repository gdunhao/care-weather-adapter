package com.care.open.weather.client;

import com.care.open.weather.model.weather.WeatherRQ;
import com.care.open.weather.model.weather.WeatherRS;

public interface OpenWeatherClient {

  WeatherRS fetchWeather(WeatherRQ weatherRQ);
}