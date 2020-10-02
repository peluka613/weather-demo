package edu.weather.controllers;

import edu.weather.model.dto.WeatherRecordDto;
import edu.weather.services.IWeatherRecordService;
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
    IWeatherRecordService weatherRecordService;

    @GetMapping()
    public ResponseEntity<List<WeatherRecordDto>> getAll() {
        List<WeatherRecordDto> weatherRecords = weatherRecordService.getAll();
        return new ResponseEntity<List<WeatherRecordDto>>(weatherRecords, HttpStatus.OK);
    }
}
