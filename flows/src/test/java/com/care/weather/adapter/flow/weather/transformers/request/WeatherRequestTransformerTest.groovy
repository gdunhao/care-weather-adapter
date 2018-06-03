package com.care.weather.adapter.flow.weather.transformers.request

import com.care.model.weather.WeatherRequest
import com.care.open.weather.model.weather.WeatherRQ
import spock.lang.Specification

class WeatherRequestTransformerTest extends Specification {

    def "Should properly transform WeatherRequest to WeatherRQ"() {
        given:
        WeatherRequest weatherRequest = givenValidWeatherRequest()
        WeatherRequestTransformer weatherRequestTransformer = new WeatherRequestTransformer()

        when:
        WeatherRQ weatherRQMessage = weatherRequestTransformer.createWeatherRQ(weatherRequest)

        then:
        weatherRQMessage
        weatherRQMessage.city == "Berlin"
        weatherRQMessage.country == "DE"
    }

    private WeatherRequest givenValidWeatherRequest() {
        new WeatherRequest(city: "Berlin", country: "DE")
    }
}