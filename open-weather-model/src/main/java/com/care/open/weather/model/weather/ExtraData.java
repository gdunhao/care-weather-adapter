package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ExtraData implements Serializable {

  private Integer type;
  private Integer id;
  private Double message;
  private String country;
  private Integer sunrise;
  private Integer sunset;
}