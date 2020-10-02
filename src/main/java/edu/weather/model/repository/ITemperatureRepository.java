package edu.weather.model.repository;

import edu.weather.model.entities.Temperature;
import edu.weather.model.entities.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITemperatureRepository extends JpaRepository<Temperature, Long> {
    List<Temperature> findAllByWeather(WeatherRecord weather);
}
