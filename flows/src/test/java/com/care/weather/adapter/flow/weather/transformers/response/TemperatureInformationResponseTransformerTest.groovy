package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class TemperatureInformationResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should add temperature information to weather response"() {
        given:
        WeatherResponse weatherResponse = new WeatherResponse()
        WeatherRS weatherRS = givenValidWeatherRS()

        when:
        TemperatureInformationResponseTransformer.addTemperatureInformation(weatherRS, weatherResponse)

        then:
        weatherResponse.temperature
        weatherResponse.temperature.current == 21.0
        weatherResponse.temperature.minimum == 19.0
        weatherResponse.temperature.maximum == 23.0
    }
}