package com.example.MovieBookingSystem.pojo;

import com.example.MovieBookingSystem.entity.Seat;

import java.util.List;

public class SeatTypePOJO {
    private Seat.Type seatType;
    private Double price;

    private List<SeatPOJO> seatPOJOList;

    public SeatTypePOJO() {
    }

    public SeatTypePOJO(Seat.Type seatType, double price, List<SeatPOJO> seatPOJOList) {
        this.seatType = seatType;
        this.price = price;
        this.seatPOJOList = seatPOJOList;
    }

    public Seat.Type getSeatType() {
        return seatType;
    }

    public void setSeatType(Seat.Type seatType) {
        this.seatType = seatType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<SeatPOJO> getSeatPOJOList() {
        return seatPOJOList;
    }

    public void setSeatPOJOList(List<SeatPOJO> seatPOJOList) {
        this.seatPOJOList = seatPOJOList;
    }

}
