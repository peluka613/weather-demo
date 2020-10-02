package edu.weather.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRecordDto {
    private Long id;
    private String date;
    private LocationDto location;
    private String[] temperature;
}
