package com.care.weather.adapter.flow.weather.transformers.response

import com.care.open.weather.model.weather.WeatherRS
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

abstract class WeatherResponseTransformerBaseTest extends Specification{

    private static final String PATH_WEATHER = '_files/unit/weather/weather.json'

    protected ClassLoader classLoader = getClass().getClassLoader()
    protected ObjectMapper objectMapper = new ObjectMapper()

    protected WeatherRS givenValidWeatherRS() {
        URL url = classLoader.getResource(PATH_WEATHER)

        objectMapper.readValue(url, WeatherRS)
    }
}