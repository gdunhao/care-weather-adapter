package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class TemperatureInformationResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should add temperature information to weather response"() {
        given:
        WeatherResponse weatherResponse = new WeatherResponse()

        when:
        TemperatureInformationResponseTransformer.addTemperatureInformation(weatherRS, weatherResponse)

        then:
        weatherResponse.temperature
        weatherResponse.temperature.current == currentTemperature
        weatherResponse.temperature.minimum == minimumTemperature
        weatherResponse.temperature.maximum == maximumTemperature

        where:
        weatherRS                   | currentTemperature | minimumTemperature | maximumTemperature
        givenValidWeatherRS()       | 21.0               | 19.0               | 23.0
        givenWeatherRSWithoutData() | null               | null               | null
    }
}