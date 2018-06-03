package com.care.weather.adapter.flow.weather.transformers.request;

import com.care.model.weather.WeatherRequest;
import com.care.open.weather.model.weather.WeatherRQ;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

@Service
public class WeatherRequestTransformer {

    @Transformer
    public WeatherRQ createWeatherRQ(WeatherRequest weatherRequest) {

        return convertWeatherRequestToWeatherRQ(weatherRequest);
    }

    private WeatherRQ convertWeatherRequestToWeatherRQ(WeatherRequest weatherRequest) {
        WeatherRQ weatherRQ = new WeatherRQ();
        weatherRQ.setCity(weatherRequest.getCity());
        weatherRQ.setCountry(weatherRequest.getCountry());

        return weatherRQ;
    }
}