package com.care.weather.adapter.flow.weather.transformers.response;

import com.care.model.weather.WeatherResponse;
import com.care.open.weather.model.weather.WeatherRS;

public class WeatherInformationResponseTransformer {

    protected static void addWeatherInformation(WeatherRS weatherRS, WeatherResponse weatherResponse) {
        weatherResponse.setDescription(weatherRS.getWeather().get(0).getDescription());
        weatherResponse.setHumidity(weatherRS.getMain().getHumidity());
    }
}