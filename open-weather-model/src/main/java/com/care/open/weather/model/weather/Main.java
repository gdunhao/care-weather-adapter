package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Main implements Serializable {

    private Double temp;
    private Double pressure;
    private Double humidity;
    private Double temp_min;
    private Double temp_max;
}