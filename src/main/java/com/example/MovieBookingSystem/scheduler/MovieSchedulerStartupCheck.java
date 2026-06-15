package com.example.MovieBookingSystem.scheduler;

import com.example.MovieBookingSystem.repository.ApplicationStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component

public class MovieSchedulerStartupCheck implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ApplicationStateRepository applicationStateRepository;

    @Autowired
    private MovieScheduler movieScheduler;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Optional<LocalDate> lastSync = applicationStateRepository.getLastSync();
        if (lastSync.isEmpty() || !lastSync.get().equals(LocalDate.now()))
        {
            movieScheduler.updateMovieStatus();
        }

        return;
    }
}
