package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Coordinate implements Serializable {

    private Double lon;
    private Double lat;
}