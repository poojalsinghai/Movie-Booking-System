package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.entity.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ApplicationStateRepository extends JpaRepository<ApplicationState, LocalDate> {

    @Query("select max(as.lastSync) from ApplicationState as")
    public Optional<LocalDate> getLastSync();
}
