package com.care.open.weather.flow.weather.transformers;

import com.care.model.weather.*;
import com.care.open.weather.model.weather.WeatherRS;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

@Service
public class WeatherResponseTransformer {

  @Transformer
  WeatherResponse createWeatherResponse(WeatherRS weatherRS) {

    return convertOpenWeatherRSToWeather(weatherRS);
  }

  private WeatherResponse convertOpenWeatherRSToWeather(WeatherRS weatherRS) {
    WeatherResponse weather = getWeatherFromWeatherRS(weatherRS);
    weather.setLocation(getLocationFromWeatherRS(weatherRS));
    weather.setTemperature(getTemperatureFromWeatherRS(weatherRS));
    weather.setWind(getWindFromWeatherRS(weatherRS));

    return weather;
  }

  private Wind getWindFromWeatherRS(WeatherRS weatherRS) {
    Wind wind = new Wind();
    wind.setSpeed(weatherRS.getWind().getSpeed());
    wind.setDegree(weatherRS.getWind().getDeg());

    return wind;
  }

  private Temperature getTemperatureFromWeatherRS(WeatherRS weatherRS) {
    Temperature temperature = new Temperature();
    temperature.setCurrent(weatherRS.getMain().getTemp());
    temperature.setMinimum(weatherRS.getMain().getTemp_min());
    temperature.setMaximum(weatherRS.getMain().getTemp_max());

    return temperature;
  }

  private Coordinate getCoordinateFromWeatherRS(WeatherRS weatherRS) {
    Coordinate coordinate = new Coordinate();
    coordinate.setLatitude(weatherRS.getCoord().getLat());
    coordinate.setLongitude(weatherRS.getCoord().getLon());

    return coordinate;
  }

  private Location getLocationFromWeatherRS(WeatherRS weatherRS) {
    Location location = new Location();
    location.setId(weatherRS.getId());
    location.setCity(weatherRS.getName());
    location.setCountry(weatherRS.getSys().getCountry());
    location.setCoordinate(getCoordinateFromWeatherRS(weatherRS));

    return location;
  }

  private WeatherResponse getWeatherFromWeatherRS(WeatherRS weatherRS){
    WeatherResponse weather = new WeatherResponse();
    weather.setDescription(weatherRS.getWeather().get(0).getDescription());
    weather.setHumidity(weatherRS.getMain().getHumidity());
    weather.setPressure(weatherRS.getMain().getPressure());
    weather.setVisibility(weatherRS.getVisibility());

    return weather;
  }
}