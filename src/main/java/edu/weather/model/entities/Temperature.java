package edu.weather.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather", referencedColumnName = "id")
    private WeatherRecord weather;

    @Column
    private Float temperature;

    public Temperature() {
    }

    public Temperature(WeatherRecord weather, Float temperature) {
        this.weather = weather;
        this.temperature = temperature;
    }
}
