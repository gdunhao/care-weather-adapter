package com.care.open.weather.model.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Wind implements Serializable {

    private Double speed;
    private Double deg;
}