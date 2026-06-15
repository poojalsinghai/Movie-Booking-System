package com.example.MovieBookingSystem.pojo;

import com.example.MovieBookingSystem.dto.TheatreDTO;
import com.example.MovieBookingSystem.entity.Theatre;

import java.time.LocalTime;
import java.util.List;

public class ShowPOJO {
    private TheatreDTO theatreDTO;
    private List<LocalTime> timings;

    public ShowPOJO() {
    }

    public ShowPOJO(TheatreDTO theatreDTO, List<LocalTime> timings) {
        this.theatreDTO = theatreDTO;
        this.timings = timings;
    }

    public TheatreDTO getTheatreDTO() {
        return theatreDTO;
    }

    public void setTheatreDTO(TheatreDTO theatreDTO) {
        this.theatreDTO = theatreDTO;
    }

    public List<LocalTime> getTimings() {
        return timings;
    }

    public void setTimings(List<LocalTime> timings) {
        this.timings = timings;
    }

}
