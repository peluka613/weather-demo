package edu.weather.services;

import edu.weather.model.dto.WeatherRecordDto;

import java.util.List;

public interface IWeatherRecordService {
    List<WeatherRecordDto> getAll();
    List<WeatherRecordDto> getAllByDate(String date);
}
