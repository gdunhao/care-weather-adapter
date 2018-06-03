package com.care.weather.adapter.flow.weather.transformers.response;

import com.care.model.weather.WeatherResponse;
import com.care.open.weather.model.weather.WeatherRS;

public class WeatherInformationResponseTransformer {

    protected static void addWeatherInformation(WeatherRS weatherRS, WeatherResponse weatherResponse) {
        if (weatherRS.getWeather() != null && !weatherRS.getWeather().isEmpty()) {
            weatherResponse.setDescription(weatherRS.getWeather().get(0).getDescription());
        }
        if (weatherRS.getMain() != null) {
            weatherResponse.setHumidity(weatherRS.getMain().getHumidity());
        }
    }
}