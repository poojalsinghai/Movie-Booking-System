package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where m.isShowing = true")
    public List<Movie> getCurrentMovies();

    @Query("select m from Movie m where m.releaseDate > :localDate")
    public List<Movie> getUpcomingMovies(LocalDate localDate);
}
