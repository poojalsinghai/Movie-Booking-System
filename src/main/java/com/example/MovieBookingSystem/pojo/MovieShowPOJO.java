package com.example.MovieBookingSystem.pojo;

import java.time.LocalDate;
import java.util.List;

public class MovieShowPOJO {
    private LocalDate date;
    private List<ShowPOJO> shows;

    public MovieShowPOJO() {
    }

    public MovieShowPOJO(LocalDate date, List<ShowPOJO> shows) {
        this.date = date;
        this.shows = shows;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ShowPOJO> getShows() {
        return shows;
    }

    public void setShows(List<ShowPOJO> shows) {
        this.shows = shows;
    }

}
