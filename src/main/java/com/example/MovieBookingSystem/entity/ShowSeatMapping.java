package com.example.MovieBookingSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "show_seat_mapping")
public class ShowSeatMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_show_id", nullable = false)
    private PictureShow pictureShow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(name = "available")
    private boolean available;

    @Column(name = "price")
    private Double price;

    public ShowSeatMapping() {
    }

    public ShowSeatMapping(PictureShow pictureShow, Seat seat, boolean available, Double price) {
        this.pictureShow = pictureShow;
        this.seat = seat;
        this.available = available;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PictureShow getPictureShow() {
        return pictureShow;
    }

    public void setPictureShow(PictureShow pictureShow) {
        this.pictureShow = pictureShow;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShowSeatMapping{" + "id=" + id + ", pictureShow=" + pictureShow + ", seat=" + seat + ", available=" + available + ", price=" + price + '}';
    }

}
