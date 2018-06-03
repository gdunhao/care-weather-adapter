package com.care.weather.adapter.flow.weather.transformers.response;

import com.care.model.weather.Location;
import com.care.model.weather.WeatherResponse;
import com.care.open.weather.model.weather.WeatherRS;

public class LocationInformationResponseTransformer {

    protected static void addLocationInformation(WeatherRS weatherRS, WeatherResponse weatherResponse) {
        Location location = new Location();
        location.setId(weatherRS.getId());
        location.setCity(weatherRS.getName());
        if (weatherRS.getSys() != null) {
            location.setCountry(weatherRS.getSys().getCountry());
        }
        weatherResponse.setLocation(location);
    }
}