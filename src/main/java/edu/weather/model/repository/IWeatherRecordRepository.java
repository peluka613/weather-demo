package edu.weather.model.repository;

import edu.weather.model.entities.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface IWeatherRecordRepository extends JpaRepository<WeatherRecord, Long> {
    List<WeatherRecord> findAllByDate(Date date);
}
