package edu.weather.services;

import edu.weather.model.dto.WeatherRecordDto;
import edu.weather.model.entities.Temperature;
import edu.weather.model.entities.WeatherRecord;
import edu.weather.model.repository.ITemperatureRepository;
import edu.weather.model.repository.IWeatherRecordRepository;
import edu.weather.utils.WeatherConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherRecordServiceImpl implements IWeatherRecordService {

    @Autowired
    IWeatherRecordRepository weatherRecodrRepository;

    @Autowired
    ITemperatureRepository temperatureRepository;

    @Override
    public List<WeatherRecordDto> getAll() {
        List<WeatherRecord> weatherRecords = weatherRecodrRepository.findAll();
        return fetchToDto(weatherRecords);
    }

    @Override
    public List<WeatherRecordDto> getAllByDate(String sDate) {
        Date date = Date.valueOf(sDate);
        List<WeatherRecord> weatherRecords = weatherRecodrRepository.findAllByDate(date);
        return fetchToDto(weatherRecords);
    }

    @Override
    public void deleteAll() {
        temperatureRepository.deleteAll();
        weatherRecodrRepository.deleteAll();
    }

    private List<WeatherRecordDto> fetchToDto(List<WeatherRecord> weatherRecords) {
        return weatherRecords.stream().map(
                weater -> WeatherConverter.convertWeatherEntityToDto(weater, getTemperatures(weater))
        ).collect(Collectors.toList());

    }

    private List<Temperature> getTemperatures(WeatherRecord weater) {
        return temperatureRepository.findAllByWeather(weater);
    }
}
