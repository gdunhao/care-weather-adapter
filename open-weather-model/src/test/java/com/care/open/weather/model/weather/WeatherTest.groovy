package com.care.open.weather.model.weather

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Unroll

class WeatherTest extends Specification {

    private static final String PATH_WEATHER_RS = 'com/care/open/weather/model/weather/weatherRS.json'

    protected ClassLoader classLoader = getClass().getClassLoader()
    protected ObjectMapper objectMapper = new ObjectMapper()

    @Unroll
    def 'Should convert weatherRS to an object successfully'() {
        given:
        URL url = classLoader.getResource(PATH_WEATHER_RS)

        when:
        WeatherRS weatherRS = objectMapper.readValue(url, WeatherRS)

        then:
        noExceptionThrown()
        weatherRS
    }
}