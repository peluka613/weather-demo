package edu.weather.services;

import edu.weather.model.entities.WeatherRecord;

import java.util.List;

public interface IWeatherRecordService {
    List<WeatherRecord> getAll();
}
