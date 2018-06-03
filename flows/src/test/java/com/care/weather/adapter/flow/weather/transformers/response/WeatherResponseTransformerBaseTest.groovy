package com.care.weather.adapter.flow.weather.transformers.response

import com.care.open.weather.model.weather.WeatherRS
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

abstract class WeatherResponseTransformerBaseTest extends Specification {

    private static final String PATH_WEATHER_RS = '_files/unit/weather/weatherRS.json'

    protected WeatherRS givenValidWeatherRS() {
        ClassLoader classLoader = getClass().getClassLoader()
        ObjectMapper objectMapper = new ObjectMapper()
        URL url = classLoader.getResource(PATH_WEATHER_RS)

        objectMapper.readValue(url, WeatherRS)
    }

    protected WeatherRS givenWeatherRSWithoutData() {
        new WeatherRS()
    }
}