package com.care.weather.adapter.flow.weather.transformers.response;

import com.care.model.weather.WeatherResponse;
import com.care.model.weather.Wind;
import com.care.open.weather.model.weather.WeatherRS;

public class WindInformationResponseTransformer {

    protected static void addWindInformation(WeatherRS weatherRS, WeatherResponse weatherResponse) {
        Wind wind = new Wind();
        if (weatherRS.getWind() != null) {
            wind.setSpeed(weatherRS.getWind().getSpeed());
        }
        weatherResponse.setWind(wind);
    }
}