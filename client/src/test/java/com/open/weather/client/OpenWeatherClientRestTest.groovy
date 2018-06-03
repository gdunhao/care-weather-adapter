package com.open.weather.client

import com.care.open.weather.client.OpenWeatherClient
import com.care.open.weather.client.OpenWeatherClientConstants
import com.care.open.weather.client.OpenWeatherClientRest
import com.care.open.weather.model.weather.WeatherRQ
import com.care.open.weather.model.weather.WeatherRS
import com.xebialabs.restito.server.StubServer
import com.xebialabs.restito.support.junit.NeedsServer
import com.xebialabs.restito.support.junit.ServerDependencyRule
import org.glassfish.grizzly.http.Method
import org.junit.Rule
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static com.xebialabs.restito.builder.stub.StubHttp.whenHttp
import static com.xebialabs.restito.builder.verify.VerifyHttp.verifyHttp
import static com.xebialabs.restito.semantics.Action.ok
import static com.xebialabs.restito.semantics.Action.resourceContent
import static com.xebialabs.restito.semantics.Condition.endsWithUri
import static com.xebialabs.restito.semantics.Condition.method

class OpenWeatherClientRestTest extends Specification {

    private static int stubServerPort = 11101
    private static String CLIENT_BASE_URL = 'http://localhost:' + stubServerPort

    @Rule
    ServerDependencyRule serverDependencyRule = new ServerDependencyRule()

    private StubServer stubServer

    OpenWeatherClient openWeatherClient = new OpenWeatherClientRest(baseurl: CLIENT_BASE_URL, apiKey: "123",
            restTemplate: new RestTemplate())

    def setup() {
        if (serverDependencyRule.isServerDependent()) {
            stubServer = new StubServer(stubServerPort).run()
        }
    }

    def cleanup() {
        if (stubServer != null) {
            stubServer.stop()
        }
    }

    @NeedsServer
    def "Should return weatherRS"() {
        given:
        whenHttp(stubServer).match(endsWithUri(OpenWeatherClientConstants.WEATHER_URL))
                .then(ok(), resourceContent("_files/unit/weather/weatherRS.json"))

        when:
        WeatherRS weatherRS = openWeatherClient.fetchWeather(new WeatherRQ(city: "Berlin", country: "DE"))

        then:
        weatherRS
        weatherRS.id == 2950159
        weatherRS.name == "Berlin"
        weatherRS.cod == 200
        weatherRS.dt == 1527151800
        weatherRS.visibility == 10000
        weatherRS.base == "stations"
        weatherRS.coord.lat == 52.52
        weatherRS.coord.lon == 13.41
        weatherRS.weather[0].id == 802
        weatherRS.weather[0].main == "Clouds"
        weatherRS.weather[0].description == "scattered clouds"
        weatherRS.weather[0].icon == "03d"
        weatherRS.main.temp == 21
        weatherRS.main.pressure == 1024
        weatherRS.main.humidity == 49
        weatherRS.main.temp_min == 21
        weatherRS.main.temp_max == 21
        weatherRS.wind.speed == 5.7
        weatherRS.wind.deg == 80
        weatherRS.clouds.all == 40
        weatherRS.sys.type == 1
        weatherRS.sys.id == 4892
        weatherRS.sys.message == 0.0027
        weatherRS.sys.country == "DE"
        weatherRS.sys.sunrise == 1527130652
        weatherRS.sys.sunset == 1527188988

        verifyHttp(stubServer).once(method(Method.GET), endsWithUri(OpenWeatherClientConstants.WEATHER_URL))
    }
}