package com.care.weather.adapter.server.weather

import spock.lang.Specification

class WeatherControllerTest extends Specification {

    def "Should make a call to weather service"() {
        given:
        WeatherService weatherService = Mock(WeatherService)
        WeatherController weatherController = new WeatherController(weatherService: weatherService)

        when:
        weatherController.fetchWeather("Berlin", "DE")

        then:
        1 * weatherService.fetchWeather(_)
    }
}