package com.example.MovieBookingSystem.mapper;

import com.example.MovieBookingSystem.dto.MovieDTO;
import com.example.MovieBookingSystem.entity.Movie;

public class MovieMapper {
    public static Movie mapToMovie (MovieDTO movieDTO) {
        Movie movie = new Movie(movieDTO.getName(), movieDTO.getDuration(), movieDTO.getReleaseDate(), movieDTO.isShowing());
        return movie;
    }

    public static MovieDTO mapToMovieDTO (Movie movie) {
        MovieDTO movieDTO = new MovieDTO(movie.getName(), movie.getDuration(), movie.getReleaseDate(), movie.getIsShowing());
        return movieDTO;
    }
}
