package com.example.MovieBookingSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_no")
    private String seatNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    public Seat() {
    }

    public Seat(String seatNo, Screen screen, Type type) {
        this.seatNo = seatNo;
        this.screen = screen;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Seat{" + "id=" + id + ", seatNo='" + seatNo + '\'' + ", screen=" + screen + ", type=" + type + '}';
    }

    public enum Type {
        CLASSIC, PREMIUM, RECLINER
    }

}
