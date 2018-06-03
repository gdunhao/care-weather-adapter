package com.care.open.weather.model.weather


import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import spock.lang.Unroll

class WeatherTest extends Specification {

    private static final String PATH_WEATHER = 'com/care/open/weather/model/weather/weather.json'

    protected ClassLoader classLoader = getClass().getClassLoader()
    protected ObjectMapper objectMapper = new ObjectMapper()

    @Unroll
    def 'Should convert weather to an object successfully'() {

        given:
        URL url = classLoader.getResource(PATH_WEATHER)

        when:
        WeatherRS location = objectMapper.readValue(url, WeatherRS)

        then:
        noExceptionThrown()
        location
    }
}