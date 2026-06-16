package com.example.MovieBookingSystem.pojo;

public class SeatPOJO {
    private String seatNo;

    private Boolean availability;

    public SeatPOJO() {
    }

    public SeatPOJO(String seatNo, Boolean availability) {
        this.seatNo = seatNo;
        this.availability = availability;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

}
