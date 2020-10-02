package edu.weather.services;

import edu.weather.model.dto.WeatherRecordDto;
import edu.weather.model.entities.WeatherRecord;

import java.util.List;

public interface IWeatherRecordService {
    List<WeatherRecordDto> getAll();
}
