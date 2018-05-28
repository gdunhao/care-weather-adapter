package com.care.open.weather.model.weather

import com.care.open.weather.model.ModelBaseTest
import spock.lang.Unroll

class WeatherTest extends ModelBaseTest {

  private static final String PATH_WEATHER = 'com/care/open/weather/model/weather/weather.json'

  @Unroll
  def 'Should convert weather to an object successfully'() {

    given:
    URL url = classLoader.getResource(PATH_WEATHER)

    when:
    WeatherRS location = objectMapper.readValue(url, WeatherRS)

    then:
    noExceptionThrown()
    location
  }
}