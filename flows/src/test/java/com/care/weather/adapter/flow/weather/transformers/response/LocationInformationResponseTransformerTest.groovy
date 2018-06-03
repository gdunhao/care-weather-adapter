package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class LocationInformationResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should add location information to weather response"() {
        given:
        WeatherResponse weatherResponse = new WeatherResponse()
        WeatherRS weatherRS = givenValidWeatherRS()

        when:
        LocationInformationResponseTransformer.addLocationInformation(weatherRS, weatherResponse)

        then:
        weatherResponse.location
        weatherResponse.location.id == 2950159
        weatherResponse.location.city == "Berlin"
        weatherResponse.location.country == "DE"
    }
}