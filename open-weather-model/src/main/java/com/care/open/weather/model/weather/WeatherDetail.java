package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class WeatherDetail implements Serializable {

  private Integer id;
  private String main;
  private String description;
  private String icon;
}