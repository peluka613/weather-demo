package edu.weather.services;

import edu.weather.model.entities.WeatherRecord;
import edu.weather.model.repository.IWeatherRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherRecordServiceImpl implements IWeatherRecordService {

    @Autowired
    IWeatherRecordRepository weatherRecodrRepository;

    @Override
    public List<WeatherRecord> getAll() {
        return weatherRecodrRepository.findAll();
    }
}
