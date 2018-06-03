package com.care.weather.adapter.flow.weather.transformers.response

import com.care.model.weather.WeatherResponse
import com.care.open.weather.model.weather.WeatherRS

class LocationInformationResponseTransformerTest extends WeatherResponseTransformerBaseTest {

    def "Should add location information to weather response"() {
        given:
        WeatherResponse weatherResponse = new WeatherResponse()

        when:
        LocationInformationResponseTransformer.addLocationInformation(weatherRS, weatherResponse)

        then:
        weatherResponse.location
        weatherResponse.location.id == locationId
        weatherResponse.location.city == locationCity
        weatherResponse.location.country == locationCountry

        where:
        weatherRS                   | locationId | locationCity | locationCountry
        givenValidWeatherRS()       | 2950159    | "Berlin"     | "DE"
        givenWeatherRSWithoutData() | null       | null         | null
    }
}