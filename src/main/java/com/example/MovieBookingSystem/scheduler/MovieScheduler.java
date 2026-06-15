package com.example.MovieBookingSystem.scheduler;

import com.example.MovieBookingSystem.entity.ApplicationState;
import com.example.MovieBookingSystem.entity.Movie;
import com.example.MovieBookingSystem.repository.ApplicationStateRepository;
import com.example.MovieBookingSystem.repository.MovieRepository;
import com.example.MovieBookingSystem.repository.PictureShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class MovieScheduler {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PictureShowRepository pictureShowRepository;

    @Autowired
    private ApplicationStateRepository applicationStateRepository;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void updateMovieStatus() {
        System.out.println("This is a scheduled job!");
        Optional<LocalDate> lastSync = applicationStateRepository.getLastSync();
        if (lastSync.isPresent() && lastSync.equals(LocalDate.now()))
        {
            return;
        }

        List<Movie> currentMovies = movieRepository.getCurrentMovies();
        List<Movie> remainingMovies = pictureShowRepository.findRemainingMovies(LocalDateTime.now(), LocalDate.now());
        HashSet<Long> remainingShows = new HashSet<>();

        for (Movie movie : remainingMovies)
        {
            if (!movie.getIsShowing())
            {
                movie.setIsShowing(true);
            }
            remainingShows.add(movie.getId());
        }

        for (Movie movie : currentMovies)
        {
            if (!remainingShows.contains(movie.getId()))
            {
                movie.setIsShowing(false);
            }
        }

        ApplicationState applicationState = new ApplicationState(LocalDate.now());
        applicationStateRepository.save(applicationState);

        return;
    }
}
