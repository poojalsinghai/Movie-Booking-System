package com.example.MovieBookingSystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TheatreDTO {

    private Long id;

    private String name;

    private String city;

    public TheatreDTO() {
    }

    public TheatreDTO(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theatre{" + ", name='" + name + '\'' + ", city='" + city + '\'' + '}';
    }

}
