package com.team.thebox.dao;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.repository.MovieAttachRepository;
import com.team.thebox.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MovieDAOImpl implements MovieDAO {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieAttachRepository movieAttachRepository;

    @Override
    public int insertMovie(Movie movie) {
        return Math.toIntExact(movieRepository.save(movie).getMovno());
    }

    @Override
    public int insertMovieAttach(MovieAttach ma) {

        return Math.toIntExact(movieAttachRepository.save(ma).getMovano());
    }

    @Override
    public Movie selectOneMovie(int mvno) {
        System.out.println("겟" + movieRepository.findById((long)mvno).get());
        return movieRepository.findById((long)mvno).get();
    }

    @Override
    public Map<String, Object> selectMovie(int cpg) {
        Pageable paging = PageRequest.of(cpg, 25, Sort.Direction.DESC, "movno");
        Map<String, Object> movs = new HashMap<>();
        movs.put("movlist", movieRepository.findAll(paging).getContent());
        movs.put("cntpg", movieRepository.findAll(paging).getTotalPages());
        return movs;
    }
//    @Override
//    public Movie selectOneMovie(int mvno) {
//        Optional<Movie> optionalMovie = movieRepository.findById(mvno);
//        if (optionalMovie.isPresent()) {
//            System.out.println("겟" + optionalMovie.get());
//            return optionalMovie.get();
//        } else {
//            // ID에 해당하는 영화가 존재하지 않을 경우 예외 처리 또는 기본 동작을 수행
//            // 예를 들어, null을 반환하거나 예외를 던질 수 있습니다.
//            return null; // 또는 원하는 처리 방식에 따라 적절히 수정
//        }
//    }
}
