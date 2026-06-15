package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.entity.Movie;
import com.example.MovieBookingSystem.entity.PictureShow;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PictureShowRepository extends JpaRepository<PictureShow, Long> {

    @Query("select ps from PictureShow ps where ps.movie.id = :movieId and ps.screen.theatre.city = :city and ps.startTime >= :currentDateTime")
    public List<PictureShow> findByMovieIdAndCity(long movieId, String city, LocalDateTime currentDateTime);

    @Query("select distinct ps.movie from PictureShow ps where ps.endTime >= :currentDateTime and ps.movie.releaseDate <= :currentDate")
    public List<Movie> findRemainingMovies(LocalDateTime currentDateTime, LocalDate currentDate);
}
