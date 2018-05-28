package com.care.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {

  private Integer id;
  private String city;
  private String country;
  private Coordinate coordinate;
}