package com.care.weather.adapter.flow.weather;

import com.care.open.weather.client.OpenWeatherClient;
import com.care.weather.adapter.flow.weather.transformers.request.WeatherRequestTransformer;
import com.care.weather.adapter.flow.weather.transformers.response.WeatherResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import static com.care.weather.adapter.flow.weather.WeatherConstants.WEATHER_CHANNEL_NAME;
import static com.care.weather.adapter.flow.weather.WeatherConstants.WEATHER_FLOW_NAME;

@Configuration
public class WeatherFlows {

    private static final String WEATHER_METHOD_NAME = "fetchWeather";

    @Autowired
    WeatherRequestTransformer weatherRequestTransformer;

    @Autowired
    WeatherResponseTransformer weatherResponseTransformer;

    @Autowired
    OpenWeatherClient openWeatherClient;

    @Bean(name = WEATHER_FLOW_NAME)
    IntegrationFlow weatherFlow() {
        return IntegrationFlows
                .from(WEATHER_CHANNEL_NAME)
                .transform(weatherRequestTransformer)
                .handle(openWeatherClient, WEATHER_METHOD_NAME)
                .transform(weatherResponseTransformer)
                .get();
    }
}