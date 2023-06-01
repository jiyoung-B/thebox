package com.team.thebox.service.admin;

import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.repository.BookedRepository;
import com.team.thebox.repository.MovieRepository;
import com.team.thebox.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("movschsrv")
@Transactional
public class MovieScheduleServiceImpl implements MovieScheduleService{
    @Autowired
    MovieScheduleRepository movieScheduleRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    BookedRepository bookedRepository;



    @Override
    public List<MovieScheduleDTO> readMovieSchedule() {
        List<MovieSchedule> movieSchedules = movieScheduleRepository.findAll();
        List<MovieScheduleDTO> scheduleDTOs = new ArrayList<>();

        for (MovieSchedule schedule : movieSchedules) {
            MovieScheduleDTO scheduleDTO = new MovieScheduleDTO();
            scheduleDTO.setId(schedule.getSchno());
            scheduleDTO.setSchno(schedule.getSchno());
            scheduleDTO.setCiplace(schedule.getCiplace());
            scheduleDTO.setOdate(schedule.getOdate());
            scheduleDTO.setStime(schedule.getStime());
            scheduleDTO.setEtime(schedule.getEtime());
            scheduleDTO.setPrice(schedule.getPrice());

            Long movno = schedule.getMovno();
            Movie movie = movieRepository.findMovTitleByMovno(movno);
            if (movie != null) {
                scheduleDTO.setMovtitle(movie.getMovtitle());
            }

            Long schno = schedule.getSchno();
            int booked = bookedRepository.countTotalSeatIdsBySchno(schno);
            scheduleDTO.setBooked(booked);

            scheduleDTOs.add(scheduleDTO);
        }

        return scheduleDTOs;
    }
}

