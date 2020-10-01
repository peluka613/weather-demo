package edu.weather.model.repository;

import edu.weather.model.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location, Long> {
}
