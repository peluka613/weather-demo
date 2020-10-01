package edu.weather.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {

    private String lat;
    private String lon;
    private String city;
    private String state;
}
