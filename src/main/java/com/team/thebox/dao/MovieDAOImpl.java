package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.repository.BookedRepository;
import com.team.thebox.repository.MovieAttachRepository;
import com.team.thebox.repository.MovieRepository;
import com.team.thebox.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("movdao")
public class MovieDAOImpl implements MovieDAO {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieAttachRepository movieAttachRepository;

    @Autowired
    MovieScheduleRepository movieScheduleRepository;
    @Autowired
    BookedRepository bookedRepository;

    @Override
    public int insertMovie(Movie movie) {
        return Math.toIntExact(movieRepository.save(movie).getMovno());
    }

    @Override
    public int insertMovieAttach(MovieAttach ma) {

        return Math.toIntExact(movieAttachRepository.save(ma).getMovano());
    }

    @Override
    public Movie selectOneMovie(int movno) {
        System.out.println("겟" + movieRepository.findById((long)movno).get());
        return movieRepository.findById((long)movno).get();
    }

    @Override
    public Map<String, Object> selectMovie(int cpg) {
        Pageable paging = PageRequest.of(cpg, 25, Sort.Direction.DESC, "movno");
        Map<String, Object> movs = new HashMap<>();
        movs.put("movlist", movieRepository.findAll(paging).getContent());
        movs.put("cntpg", movieRepository.findAll(paging).getTotalPages());
        return movs;
    }

    @Override
    public List<String> selectMovieTitle() {
        return movieRepository.findMovTitleByMovno();
    }

    @Override
    public int insertMovieSchedule(MovieSchedule movsch) {
        return Math.toIntExact(movieScheduleRepository.save(movsch).getSchno());
    }

    @Override
    public List<Movie> selectMovnoAndTitle() {
        return movieRepository.findAll();
    }

    @Override
    public List<MovieSchedule> selectMovieSchdule() {
        return movieScheduleRepository.findAll();
    }

    @Override
    public int selectBookedCnt() {
        return bookedRepository.countTotalSeatIds();
    }

}
