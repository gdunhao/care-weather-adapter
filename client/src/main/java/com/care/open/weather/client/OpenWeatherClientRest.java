package com.care.open.weather.client;

import com.care.open.weather.model.weather.WeatherRQ;
import com.care.open.weather.model.weather.WeatherRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.care.open.weather.client.OpenWeatherClientConstants.WEATHER_URL;

@Component
public class OpenWeatherClientRest implements OpenWeatherClient {

    @Value("${provider.open-weather-api.url}")
    String baseurl;

    @Value("${provider.open-weather-api.apiKey}")
    String apiKey;

    @Autowired
    RestTemplate restTemplate;

    public WeatherRS fetchWeather(WeatherRQ weatherRQ) {

        return restTemplate.getForObject(concatWithBaseUrl(WEATHER_URL) + "?q={city},{country}&appid={appid}&units=metric",
                WeatherRS.class, weatherRQ.getCity(), weatherRQ.getCountry(), apiKey);
    }

    private String concatWithBaseUrl(String url) {

        return baseurl.concat(url);
    }
}