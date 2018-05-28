package com.care.model.weather

import com.care.model.ModelBaseTest
import spock.lang.Unroll

class WeatherTest extends ModelBaseTest {

  private static final String PATH_WEATHER = 'com/care/model/weather/weather.json'

  @Unroll
  def 'Should convert weather to an object successfully'() {

    given:
    URL url = classLoader.getResource(PATH_WEATHER)

    when:
    WeatherResponse location = objectMapper.readValue(url, WeatherResponse)

    then:
    noExceptionThrown()
    location
  }
}