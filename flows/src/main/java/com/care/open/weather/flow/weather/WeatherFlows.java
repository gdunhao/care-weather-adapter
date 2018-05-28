package com.care.open.weather.flow.weather;

import com.care.open.weather.client.OpenWeatherClient;
import com.care.open.weather.flow.weather.transformers.WeatherRequestTransformer;
import com.care.open.weather.flow.weather.transformers.WeatherResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import static com.care.open.weather.flow.weather.WeatherConstants.FETCH_WEATHER_CHANNEL_NAME;
import static com.care.open.weather.flow.weather.WeatherConstants.FETCH_WEATHER_FLOW_NAME;

@Configuration
public class WeatherFlows {

  private static final String WEATHER_METHOD_NAME = "fetchWeather";

  @Autowired
  WeatherRequestTransformer weatherRequestTransformer;

  @Autowired
  WeatherResponseTransformer weatherResponseTransformer;

  @Autowired
  OpenWeatherClient openWeatherClient;

  @Bean(name = FETCH_WEATHER_FLOW_NAME)
  IntegrationFlow fetchWeatherFlow() {
    return IntegrationFlows
      .from(FETCH_WEATHER_CHANNEL_NAME)
      .transform(weatherRequestTransformer)
      .handle(openWeatherClient, WEATHER_METHOD_NAME)
      .transform(weatherResponseTransformer)
      .get();
  }
}