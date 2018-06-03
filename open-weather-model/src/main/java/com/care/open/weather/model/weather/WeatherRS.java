package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class WeatherRS implements Serializable {

    private Integer id;
    private String name;
    private Integer dt;
    private String base;
    private Integer visibility;
    private Integer cod;
    private Coordinate coord;
    private List<WeatherDetail> weather;
    private Main main;
    private ExtraData sys;
    private Clouds clouds;
    private Wind wind;
}