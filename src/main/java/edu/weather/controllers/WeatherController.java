package edu.weather.controllers;

import edu.weather.model.entities.WeatherRecord;
import edu.weather.model.repository.ILocationRepository;
import edu.weather.model.repository.IWeatherRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    IWeatherRecordRepository weatherRecodrRepository;

    @Autowired
    ILocationRepository iLocationRepository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping()
    public ResponseEntity<List<WeatherRecord>> getAll() {
        List<WeatherRecord> weatherRecords = weatherRecodrRepository.findAll();
        return new ResponseEntity<List<WeatherRecord>>(weatherRecords, HttpStatus.OK);
    }
}
