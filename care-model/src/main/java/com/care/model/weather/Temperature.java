package com.care.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Temperature {

  private Double current;
  private Double minimum;
  private Double maximum;
}