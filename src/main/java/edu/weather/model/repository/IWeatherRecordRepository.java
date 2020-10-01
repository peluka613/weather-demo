package edu.weather.model.repository;

import edu.weather.model.entities.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWeatherRecordRepository extends JpaRepository<WeatherRecord, Long> {
}
