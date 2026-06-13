package com.example.MovieBookingSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_show_seat_mapping")
public class BookingShowSeatMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_seat_id", nullable = false)
    private ShowSeatMapping showSeatMapping;

    public BookingShowSeatMapping() {
    }

    public BookingShowSeatMapping(Booking booking, ShowSeatMapping showSeatMapping) {
        this.booking = booking;
        this.showSeatMapping = showSeatMapping;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ShowSeatMapping getShowSeatMapping() {
        return showSeatMapping;
    }

    public void setShowSeatMapping(ShowSeatMapping showSeatMapping) {
        this.showSeatMapping = showSeatMapping;
    }

    @Override
    public String toString() {
        return "BookingShowSeatMapping{" + "id=" + id + ", booking=" + booking + ", showSeatMapping=" + showSeatMapping + '}';
    }

}
