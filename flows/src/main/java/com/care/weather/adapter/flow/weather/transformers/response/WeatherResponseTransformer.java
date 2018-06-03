package com.care.weather.adapter.flow.weather.transformers.response;

import com.care.model.weather.WeatherResponse;
import com.care.open.weather.model.weather.WeatherRS;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

import static com.care.weather.adapter.flow.weather.transformers.response.WeatherInformationResponseTransformer.addWeatherInformation;
import static com.care.weather.adapter.flow.weather.transformers.response.WindInformationResponseTransformer.addWindInformation;
import static com.care.weather.adapter.flow.weather.transformers.response.LocationInformationResponseTransformer.addLocationInformation;
import static com.care.weather.adapter.flow.weather.transformers.response.TemperatureInformationResponseTransformer.addTemperatureInformation;

@Service
public class WeatherResponseTransformer {

    @Transformer
    public WeatherResponse createWeatherResponse(WeatherRS weatherRS) {

        return convertWeatherRSToWeatherResponse(weatherRS);
    }

    private WeatherResponse convertWeatherRSToWeatherResponse(WeatherRS weatherRS) {
        WeatherResponse weatherResponse = new WeatherResponse();
        addWeatherInformation(weatherRS, weatherResponse);
        addLocationInformation(weatherRS, weatherResponse);
        addTemperatureInformation(weatherRS, weatherResponse);
        addWindInformation(weatherRS, weatherResponse);

        return weatherResponse;
    }
}