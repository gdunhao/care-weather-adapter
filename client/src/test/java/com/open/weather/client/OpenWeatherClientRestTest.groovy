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
  def "Should return weather response"() {
    given:
    whenHttp(stubServer).match(endsWithUri(OpenWeatherClientConstants.WEATHER_URL))
      .then(ok(), resourceContent("_files/unit/weather/weather.json"))

    when:
    WeatherRS response = openWeatherClient.fetchWeather(new WeatherRQ(city: "Berlin", country: "DE"))

    then:
    response
    response.id == 2950159
    response.name == "Berlin"
    response.cod == 200
    response.dt == 1527151800
    response.visibility == 10000
    response.base == "stations"
    response.coord.lat == 52.52
    response.coord.lon == 13.41
    response.weather[0].id == 802
    response.weather[0].main == "Clouds"
    response.weather[0].description == "scattered clouds"
    response.weather[0].icon == "03d"
    response.main.temp == 21
    response.main.pressure == 1024
    response.main.humidity == 49
    response.main.temp_min == 21
    response.main.temp_max == 21
    response.wind.speed == 5.7
    response.wind.deg == 80
    response.clouds.all == 40
    response.sys.type == 1
    response.sys.id == 4892
    response.sys.message == 0.0027
    response.sys.country == "DE"
    response.sys.sunrise == 1527130652
    response.sys.sunset == 1527188988

    verifyHttp(stubServer).once(method(Method.GET), endsWithUri(OpenWeatherClientConstants.WEATHER_URL))
  }
}