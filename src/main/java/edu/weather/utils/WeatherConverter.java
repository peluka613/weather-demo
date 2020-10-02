package edu.weather.utils;

import edu.weather.model.dto.LocationDto;
import edu.weather.model.dto.WeatherRecordDto;
import edu.weather.model.entities.Location;
import edu.weather.model.entities.Temperature;
import edu.weather.model.entities.WeatherRecord;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherConverter {

    public static WeatherRecordDto convertWeatherEntityToDto(WeatherRecord weatherRecord, List<Temperature> temperatures) {
        WeatherRecordDto weatherRecordDto = new WeatherRecordDto();

        weatherRecordDto.setId(weatherRecord.getId());
        weatherRecordDto.setDate(new SimpleDateFormat("yyyy-MM-dd").format(weatherRecord.getDate()));
        weatherRecordDto.setLocation(fetchLocationEntityToDto(weatherRecord.getLocation()));
        weatherRecordDto.setTemperature(fetchTemperaturesToAttay(temperatures));

        return weatherRecordDto;
    }

    private static LocationDto fetchLocationEntityToDto(Location location) {
        NumberFormat formatter = new DecimalFormat("#0.0000");
        LocationDto locationDto = new LocationDto();
        locationDto.setLat(formatter.format(location.getLat()));
        locationDto.setLon(formatter.format(location.getLon()));
        locationDto.setCity(location.getCity());
        locationDto.setState(location.getState());

        return locationDto;
    }

    private static String[] fetchTemperaturesToAttay(List<Temperature> temperatures) {
        NumberFormat formatter = new DecimalFormat("#0.0");
        return temperatures.stream()
                .map(Temperature::getTemperature)
                .map(temp -> formatter.format(temp))
                .collect(Collectors.toList()).toArray(new String[0]);


    }

}
