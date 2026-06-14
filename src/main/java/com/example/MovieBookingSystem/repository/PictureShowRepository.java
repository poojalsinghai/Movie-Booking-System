package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.entity.PictureShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureShowRepository extends JpaRepository<PictureShow, Long> {

    @Query("select ps from PictureShow ps where ps.movie.id = :movieId and ps.screen.theatre.city = :city")
    public List<PictureShow> findByMovieIdAndCity(long movieId, String city);
}
