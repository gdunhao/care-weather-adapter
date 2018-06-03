package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class WindInformationResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should add wind information to weather response"() {
        given:
        WeatherResponse weatherResponse = new WeatherResponse()
        WeatherRS weatherRS = givenValidWeatherRS()

        when:
        WindInformationResponseTransformer.addWindInformation(weatherRS, weatherResponse)

        then:
        weatherResponse.wind
        weatherResponse.wind.speed == 5.7
    }
}