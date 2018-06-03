package com.care.model.weather

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Unroll

class WeatherTest extends Specification {

    private static final String PATH_WEATHER_RESPONSE = 'com/care/model/weather/weatherResponse.json'
    private static final String PATH_WEATHER_REQUEST = 'com/care/model/weather/weatherRequest.json'

    protected ClassLoader classLoader = getClass().getClassLoader()
    protected ObjectMapper objectMapper = new ObjectMapper()

    @Unroll
    def 'Should convert weatherResponse to an object successfully'() {
        given:
        URL url = classLoader.getResource(PATH_WEATHER_RESPONSE)

        when:
        WeatherResponse weatherResponse = objectMapper.readValue(url, WeatherResponse)

        then:
        noExceptionThrown()
        weatherResponse
    }

    @Unroll
    def 'Should convert weatherRequest to an object successfully'() {
        given:
        URL url = classLoader.getResource(PATH_WEATHER_REQUEST)

        when:
        WeatherRequest weatherRequest = objectMapper.readValue(url, WeatherRequest)

        then:
        noExceptionThrown()
        weatherRequest
    }
}