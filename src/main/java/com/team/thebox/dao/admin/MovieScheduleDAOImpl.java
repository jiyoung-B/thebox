package com.team.thebox.dao.admin;

import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.repository.BookedRepository;
import com.team.thebox.repository.MovieRepository;
import com.team.thebox.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("movschdao")
public class MovieScheduleDAOImpl implements MovieScheduleDAO {
    @Autowired
    MovieScheduleRepository movieScheduleRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    BookedRepository bookedRepository;



    @Override
    public List<MovieSchedule> selectMovieSchedule() {
        return movieScheduleRepository.findAll();

    }

    @Override
    public Movie selectMovieTitleByMovno(Long movno) {
        return  movieRepository.findMovTitleByMovno(movno);
    }

    @Override
    public int getBookedCount(Long schno) {
        return bookedRepository.countTotalSeatIdsBySchno(schno);
    }

    @Override
    public MovieSchedule selectOneSchedule(Long schno) {
        return movieScheduleRepository.findById(schno).orElse(null);
    }

    @Override
    public Long updateMoviesSchedule(MovieSchedule schedule) {
        System.out.println("저장직전repository"+schedule);

        return movieScheduleRepository.save(schedule).getSchno();

    }

}
