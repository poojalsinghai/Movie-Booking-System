package com.example.MovieBookingSystem.controller;

import com.example.MovieBookingSystem.dto.MovieDTO;
import com.example.MovieBookingSystem.pojo.MovieShowPOJO;
import com.example.MovieBookingSystem.pojo.SeatTypePOJO;
import com.example.MovieBookingSystem.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/movie-shows/{movieId}/{city}")
    public List<MovieShowPOJO> getMovieShows(@PathVariable long movieId, @PathVariable String city) {
        // System.out.println(movieId);
        return customerService.getMovieShows(movieId, city);
    }

    @GetMapping("/current-movies")
    public List<MovieDTO> getCurrentMovies() {
        return customerService.getCurrentMovies();
    }

    @GetMapping("/upcoming-movies")
    public List<MovieDTO> getUpcomingMovies() {
        return customerService.getUpcomingMovies();
    }

    @GetMapping("/seats/{pictureShowId}")
    public List<SeatTypePOJO> getShowSeats(@PathVariable long pictureShowId) {
        return customerService.getShowSeats(pictureShowId);
    }
}
