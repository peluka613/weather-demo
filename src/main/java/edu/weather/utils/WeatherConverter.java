package edu.weather.utils;

import edu.weather.model.dto.LocationDto;
import edu.weather.model.dto.WeatherRecordDto;
import edu.weather.model.entities.Location;
import edu.weather.model.entities.Temperature;
import edu.weather.model.entities.WeatherRecord;
import org.modelmapper.ModelMapper;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public abstract class WeatherConverter {

    private WeatherConverter() throws IllegalAccessException {
        throw new IllegalAccessException("private constructor");
    }

    public static WeatherRecord convertWeatherDtoToEntity(WeatherRecordDto weatherRecordDto) {
        WeatherRecord weatherRecord = new WeatherRecord();

        weatherRecord.setId(weatherRecordDto.getId());
        weatherRecord.setDate(Date.valueOf(weatherRecordDto.getDate()));
        weatherRecord.setLocation(fetchLocationDtoToEntity(weatherRecordDto.getLocation()));

        return weatherRecord;
    }

    public static WeatherRecordDto convertWeatherEntityToDto(WeatherRecord weatherRecord, List<Temperature> temperatures) {
        WeatherRecordDto weatherRecordDto = new WeatherRecordDto();

        weatherRecordDto.setId(weatherRecord.getId());
        weatherRecordDto.setDate(new SimpleDateFormat("yyyy-MM-dd").format(weatherRecord.getDate()));
        weatherRecordDto.setLocation(fetchLocationEntityToDto(weatherRecord.getLocation()));
        weatherRecordDto.setTemperature(fetchTemperaturesToArray(temperatures));

        return weatherRecordDto;
    }

    private static Location fetchLocationDtoToEntity(LocationDto locationDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(locationDto, Location.class);
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

    private static String[] fetchTemperaturesToArray(List<Temperature> temperatures) {
        NumberFormat formatter = new DecimalFormat("#0.0");
        return temperatures.stream()
                .map(Temperature::getTemperature)
                .map(formatter::format)
                .collect(Collectors.toList()).toArray(new String[0]);
    }

    private static BiFunction<WeatherRecord, Float, Temperature> createTemperature = Temperature::new;

    public static List<Temperature> extractTemperatures(WeatherRecord weatherRecord, String[] temps) {
        return Arrays.stream(temps).map(
                temp -> createTemperature.apply(weatherRecord, Float.parseFloat(temp))
        ).collect(Collectors.toList());
    }
}
