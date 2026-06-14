package com.example.MovieBookingSystem.service;

import com.example.MovieBookingSystem.dto.TheatreDTO;
import com.example.MovieBookingSystem.mapper.TheatreMapper;
import com.example.MovieBookingSystem.pojo.MovieShowPOJO;
import com.example.MovieBookingSystem.pojo.ShowPOJO;
import com.example.MovieBookingSystem.entity.PictureShow;
import com.example.MovieBookingSystem.entity.Screen;
import com.example.MovieBookingSystem.entity.Theatre;
import com.example.MovieBookingSystem.repository.PictureShowRepository;
import com.example.MovieBookingSystem.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class CustomerService {
    private PictureShowRepository pictureShowRepository;
    private TheatreRepository theatreRepository;

    public CustomerService(PictureShowRepository pictureShowRepository, TheatreRepository theatreRepository) {
        this.pictureShowRepository = pictureShowRepository;
        this.theatreRepository = theatreRepository;
    }

    public List<MovieShowPOJO> getMovieShows(long movieId, String city) {
        List<PictureShow> movieShows = pictureShowRepository.findByMovieIdAndCity(movieId, city);
        HashMap<LocalDate, HashMap<Long, List<LocalTime>>> map1 = new HashMap<>();

        int n = movieShows.size();
        for (int i = 0; i < n; i++)
        {
            Screen screen = movieShows.get(i).getScreen();
            Theatre theatre = screen.getTheatre();
            Long theatreId = theatre.getId();

            LocalDateTime startTime = movieShows.get(i).getStartTime();

            LocalDate date = startTime.toLocalDate();

            if (!map1.containsKey(date))
            {
                HashMap<Long, List<LocalTime>> map2 = new HashMap<>();
                map1.put(date, map2);
            }

            if (!map1.get(date).containsKey(theatreId))
            {
                List<LocalTime> list = new ArrayList<>();
                map1.get(date).put(theatreId, list);
            }

            map1.get(date).get(theatreId).add(startTime.toLocalTime());
        }

        List<MovieShowPOJO> list = new ArrayList<>();
        for (Map.Entry<LocalDate, HashMap<Long, List<LocalTime>>> entry1 : map1.entrySet())
        {
            LocalDate localDate = entry1.getKey();
            HashMap<Long, List<LocalTime>> map2 = entry1.getValue();

            List<ShowPOJO> shows = new ArrayList<>();
            for (Map.Entry<Long, List<LocalTime>> entry2 : map2.entrySet())
            {
                Optional<Theatre> theatre = theatreRepository.findById(entry2.getKey());
                if (theatre.isPresent())
                {
                    TheatreDTO theatreDTO = TheatreMapper.mapToTheatreDTO(theatre.get());
                    ShowPOJO showPOJO = new ShowPOJO(theatreDTO, entry2.getValue());
                    Collections.sort(showPOJO.getTimings());
                    shows.add(showPOJO);
                }
            }

            MovieShowPOJO movieShowPOJO = new MovieShowPOJO(localDate, shows);
            list.add(movieShowPOJO);
        }
        Collections.sort(list, Comparator.comparing(MovieShowPOJO::getDate));

        return list;
    }
}
