package edu.weather.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WeatherRecordDto {

    @NotNull
    private Long id;

    @NotNull
    private String date;

    @NotNull
    private LocationDto location;

    @NotNull
    private String[] temperature;
}
