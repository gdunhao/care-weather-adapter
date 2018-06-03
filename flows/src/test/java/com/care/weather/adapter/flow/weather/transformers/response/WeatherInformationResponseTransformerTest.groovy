package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class WeatherInformationResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should add weather information to weather response"() {
        given:
        WeatherResponse weatherResponse = new WeatherResponse()

        when:
        WeatherInformationResponseTransformer.addWeatherInformation(weatherRS, weatherResponse)

        then:
        weatherResponse
        weatherResponse.description == weatherDescription
        weatherResponse.humidity == humidity

        where:
        weatherRS                   | weatherDescription | humidity
        givenValidWeatherRS()       | "scattered clouds" | 49
        givenWeatherRSWithoutData() | null               | null
    }
}