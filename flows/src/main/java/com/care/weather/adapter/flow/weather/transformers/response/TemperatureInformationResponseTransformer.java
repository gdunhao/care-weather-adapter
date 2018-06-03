package com.care.weather.adapter.flow.weather.transformers.response;

import com.care.model.weather.Temperature;
import com.care.model.weather.WeatherResponse;
import com.care.open.weather.model.weather.WeatherRS;

public class TemperatureInformationResponseTransformer {

    protected static void addTemperatureInformation(WeatherRS weatherRS, WeatherResponse weatherResponse) {
        Temperature temperature = new Temperature();
        if (weatherRS.getMain() != null) {
            temperature.setCurrent(weatherRS.getMain().getTemp());
            temperature.setMinimum(weatherRS.getMain().getTemp_min());
            temperature.setMaximum(weatherRS.getMain().getTemp_max());

        }
        weatherResponse.setTemperature(temperature);
    }
}