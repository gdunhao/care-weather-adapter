package com.care.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherResponse {

  private Location location;
  private String description;
  private Temperature temperature;
  private Double humidity;
  private Double pressure;
  private Integer visibility;
  private Wind wind;
}