package com.example.MovieBookingSystem.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "screen")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "screen_no")
    private int screenNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    public Screen() {
    }

    public Screen(int screenNo, Theatre theatre) {
        this.screenNo = screenNo;
        this.theatre = theatre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(int screenNo) {
        this.screenNo = screenNo;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    @Override
    public String toString() {
        return "Screen{" + "id=" + id + ", screenNo=" + screenNo + ", theatre=" + theatre + '}';
    }

}
