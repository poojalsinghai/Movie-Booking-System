package com.example.MovieBookingSystem.mapper;

import com.example.MovieBookingSystem.dto.TheatreDTO;
import com.example.MovieBookingSystem.entity.Theatre;

import java.util.Optional;

public class TheatreMapper {
    public static Theatre mapToTheatre(TheatreDTO theatreDTO) {
        Theatre theatre = new Theatre(theatreDTO.getName(), theatreDTO.getCity());
        return theatre;
    }

    public static TheatreDTO mapToTheatreDTO(Theatre theatre) {
        TheatreDTO theatreDTO = new TheatreDTO(theatre.getName(), theatre.getCity());
        return theatreDTO;
    }
}
