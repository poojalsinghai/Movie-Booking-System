package com.example.MovieBookingSystem.dto;
import jakarta.persistence.*;

import java.sql.Date;

public class MovieDTO {

    private Long id;

    private String name;

    private int duration;

    private Date releaseDate;

    private boolean isShowing;

    public MovieDTO(String name, int duration, Date releaseDate, boolean isShowing) {
        this.name = name;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.isShowing = isShowing;
    }

    public MovieDTO() {
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }

}

