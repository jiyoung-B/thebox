package com.team.thebox.service.admin;

import com.team.thebox.dao.admin.MovieScheduleDAO;
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
public class AMovieScheduleServiceImpl implements AMovieScheduleService {
    @Autowired
    MovieScheduleRepository movieScheduleRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    BookedRepository bookedRepository;

    @Autowired
    MovieScheduleDAO movschdao;



    @Override
    public List<MovieScheduleDTO> readMovieSchedule() {
        List<MovieSchedule> movieSchedules = movschdao.selectMovieSchedule();
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
            Movie movie = movschdao.selectMovieTitleByMovno(movno);
            if (movie != null) {
                scheduleDTO.setMovtitle(movie.getMovtitle());
            }

            Long schno = schedule.getSchno();
            int booked = movschdao.getBookedCount(schno);
            scheduleDTO.setBooked(booked);

            scheduleDTOs.add(scheduleDTO);
        }

        return scheduleDTOs;
    }

    @Override
    public MovieSchedule getOneMovieScheduleBySchno(Long schno) {
        return movschdao.selectOneSchedule(schno);
    }

    @Override
    public boolean modifyMovieScheduleBySchno(MovieSchedule schedule) {
        boolean result = false;

        System.out.println("변경내역"+schedule);

            if(movschdao.updateMoviesSchedule(schedule) > 0 ){
            result = true;
        }
        return result;
    }
}

