package edu.weather.controllers;

import edu.weather.model.dto.WeatherRecordDto;
import edu.weather.services.IWeatherRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    IWeatherRecordService weatherRecordService;

    @PostMapping("/weather")
    public ResponseEntity createWeatherRecord(@RequestBody WeatherRecordDto weatherRecordDto) {
        try {
            weatherRecordService.save(weatherRecordDto);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<List<WeatherRecordDto>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<WeatherRecordDto>>(HttpStatus.CREATED);
    }

    @GetMapping("/weather")
    public ResponseEntity<List<WeatherRecordDto>> getAllByDate(@RequestParam(required = false) String date) {
        try {
            List<WeatherRecordDto> weatherRecords;

            if (date == null) {
                weatherRecords = weatherRecordService.getAll();
            } else {
                weatherRecords = weatherRecordService.getAllByDate(date);
            }

            if (weatherRecords.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<WeatherRecordDto>>(weatherRecords, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity deleteAll() {
        weatherRecordService.deleteAll();
        return new ResponseEntity<List<WeatherRecordDto>>(HttpStatus.OK);
    }
}
