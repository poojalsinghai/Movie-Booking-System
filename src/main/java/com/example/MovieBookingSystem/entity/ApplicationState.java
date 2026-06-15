package com.example.MovieBookingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "application_state")
public class ApplicationState {

    @Id
    @Column(name = "last_sync")
    private LocalDate lastSync;

    public ApplicationState() {
    }

    public ApplicationState(LocalDate lastSync) {
        this.lastSync = lastSync;
    }

    public LocalDate getLastSync() {
        return lastSync;
    }

    public void setLastSync(LocalDate lastSync) {
        this.lastSync = lastSync;
    }

}
