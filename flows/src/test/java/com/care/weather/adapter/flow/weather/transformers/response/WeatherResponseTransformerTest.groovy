package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class WeatherResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should properly transform WeatherRS to WeatherResponse"() {
        given:
        WeatherResponseTransformer weatherResponseTransformer = new WeatherResponseTransformer()
        WeatherRS weatherRS = givenValidWeatherRS()

        when:
        WeatherResponse weatherResponse = weatherResponseTransformer.createWeatherResponse(weatherRS)

        then:
        weatherResponse
        weatherResponse.description == "scattered clouds"
        weatherResponse.humidity == 49
        weatherResponse.temperature
        weatherResponse.temperature.current == 21
        weatherResponse.temperature.minimum == 19
        weatherResponse.temperature.maximum == 23
        weatherResponse.location
        weatherResponse.location.id == 2950159
        weatherResponse.location.city == "Berlin"
        weatherResponse.location.country == "DE"
        weatherResponse.wind
        weatherResponse.wind.speed == 5.7
    }
}