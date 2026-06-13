package com.example.MovieBookingSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser appUser;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "time_of_booking")
    private LocalDateTime timeOfBooking;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Booking() {
    }

    public Booking(AppUser appUser, Double amount, LocalDateTime timeOfBooking, Status status) {
        this.appUser = appUser;
        this.amount = amount;
        this.timeOfBooking = timeOfBooking;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(LocalDateTime timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", appUser=" + appUser + ", amount=" + amount + ", timeOfBooking=" + timeOfBooking + ", status=" + status + '}';
    }

    public enum Status {
        LOCKED, CONFIRMED, CANCELLED
    }

}
