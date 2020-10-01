package edu.weather.controllers;

import edu.weather.model.dto.LocationDto;
import edu.weather.model.entities.Location;
import edu.weather.model.repository.ILocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    @Autowired
    ILocationRepository iLocationRepository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping()
    public ResponseEntity<List<LocationDto>> getAll() {

        List<Location> locations = iLocationRepository.findAll();
        List<LocationDto> locationDtos = locations
                .stream()
                .map(location -> modelMapper.map(location, LocationDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<LocationDto>>(locationDtos, HttpStatus.OK);
    }
}
