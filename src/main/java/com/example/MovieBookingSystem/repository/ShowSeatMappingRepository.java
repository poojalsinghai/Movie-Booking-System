package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.entity.PictureShow;
import com.example.MovieBookingSystem.entity.Seat;
import com.example.MovieBookingSystem.entity.ShowSeatMapping;
import com.example.MovieBookingSystem.pojo.SeatPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatMappingRepository extends JpaRepository<ShowSeatMapping, Long> {

    @Query("select ssm from ShowSeatMapping ssm where ssm.pictureShow = :pictureShow")
    public List<ShowSeatMapping> getShowSeatMapping(PictureShow pictureShow);
}
