package com.care.weather.adapter.server.weather;

import com.care.model.weather.WeatherResponse;
import com.care.model.weather.WeatherRequest;
import com.care.weather.adapter.server.configuration.WeatherAdapterEndpointPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = WeatherAdapterEndpointPath.WEATHER_ADAPTER_WEATHER_ENDPOINT)
public class WeatherController {

  @Autowired
  WeatherService weatherService;

  @GetMapping
  ResponseEntity fetchWeather(@RequestParam String city, @RequestParam String country) {

    WeatherRequest weatherRequest = new WeatherRequest();
    weatherRequest.setCity(city);
    weatherRequest.setCountry(country);

    WeatherResponse response = weatherService.fetchWeather(weatherRequest);

    HttpHeaders responseHeaders = createResponseHeader();

    return new ResponseEntity(response, responseHeaders, HttpStatus.OK);
  }

  private HttpHeaders createResponseHeader() {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setAccessControlAllowOrigin("*");
    List<HttpMethod> httpMethods = new ArrayList<>();
    httpMethods.add(HttpMethod.GET);
    responseHeaders.setAccessControlAllowMethods(httpMethods);

    return responseHeaders;
  }
}