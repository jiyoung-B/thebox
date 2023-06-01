package com.team.thebox.dao.admin;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieReply;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("amovdao")
public class AMovieDAOImpl implements AMovieDAO {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieAttachRepository movieAttachRepository;

    @Autowired
    MovieReplyRepository movieReplyRepository;

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
    public Map<String, Object> selectMovie(int cpg) {
        Pageable paging = PageRequest.of(cpg, 25, Sort.Direction.DESC, "movno");
        Map<String, Object> movs = new HashMap<>();
        movs.put("movlist", movieRepository.findAll(paging).getContent());
        movs.put("cntpg", movieRepository.findAll(paging).getTotalPages());
        return movs;
    }

//    @Override
//    public List<String> selectMovieTitle(long movno) {
//        return movieRepository.findMovTitleByMovno(movno);
//    }
    @Override //now
    public Map<String, Object> selectMovie() {
        Map<String, Object> movs = new HashMap<>();
        movs.put("mlist", movieRepository.findAll() );
        return movs;
    }

    @Override
    public int insertMovieReply(MovieReply reply) {
        return  Math.toIntExact(movieReplyRepository.save(reply).getMovno() );
    }

    @Override
    public List<MovieReply> selectOneMovieReply(int movno) {
        return movieReplyRepository.findByMovnoOrderByRegdateAsc(movno);
    }

    @Override //상세보기
    public Movie selectOneMovie(int movno) {
        return movieRepository.findById((long) movno).get();
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

    @Override
    public List<String> selectMovieTitle() {
        //return movieRepository.findMovTitleByMovno(movno);
        return null;
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
    public List<Integer> selectBookedCnt() {
        return bookedRepository.countTotalSeatIds();
    }

    @Override
    public Map<String, Object> selectScheduleList(Long movno, Long schno) {
        Map<String, Object> movschlist = new HashMap<>();
        movschlist.put("movschlist", movieScheduleRepository.findAll());
        movschlist.put("movtitle", movieRepository.findMovTitleByMovno(movno));
        movschlist.put("booked", bookedRepository.countTotalSeatIdsBySchno(schno));
        return movschlist;
    }

}
