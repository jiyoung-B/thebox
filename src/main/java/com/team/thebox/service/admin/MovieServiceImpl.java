package com.team.thebox.service.admin;

import com.team.thebox.dao.MovieDAO;
import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.utils.PdsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("admmvsrv")
@Transactional
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieDAO movdao;
    @Autowired
    PdsUtils pdsUtils;

    @Override
    public Map<String, Object> newMovies(Movie movie) {

        movie.setUuid(pdsUtils.makeUUID());   // 식별코드 생성
        int movno = movdao.insertMovie(movie);    // 폼 데이터 디비에 저장

        // 첨부파일을 시스템에 저장할때 사용할 정보를 Map에 저장
        Map<String, Object> movinfo = new HashMap<>();
        movinfo.put("movno", movno);
        movinfo.put("uuid", movie.getUuid());



        return movinfo;

    }

    @Override
    public boolean newMovies2(Movie movie) {
        boolean result = false;
        if(movdao.insertMovie(movie) > 0) {result = true;}
        return result;
    }

    @Override
    public boolean newMovieAttach(MultipartFile attach, Map<String, Object> movinfo) {
        // 첨부파일 업로드 처리
        MovieAttach ma = pdsUtils.processUpload(attach, movinfo);
        // 첨부파일 정보 디비에 저장
        int movano = movdao.insertMovieAttach(ma);

        return (movano > 0) ? true : false;
    }

    @Override
    public Movie readOneMovie(int movno) {
        return movdao.selectOneMovie(movno);
    }

    @Override
    public Map<String, Object> readMovie(Integer cpg) {
        return movdao.selectMovie(cpg - 1);
    }

    @Override
    public List<String> readMovieTitle(long movno) {
//        return movdao.selectMovieTitle(movno);
        return null;
    }

    @Override
    public List<Movie> readMovnoAndTitle() {
        return movdao.selectMovnoAndTitle();
    }

    @Override
    public boolean newMovieSchedule(MovieSchedule movsch) {
        boolean result = false;
        if(movdao.insertMovieSchedule(movsch) > 0) {result = true;}
        return result;
    }

    @Override
    public List<MovieSchedule> readSchedule() {
        return movdao.selectMovieSchdule();
    }

    @Override
    public List<Integer> readBookedCnt() {
        return movdao.selectBookedCnt();
    }

    @Override
    public Map<String, Object> readMovieSchedule(Long movno, Long schno) {

        return movdao.selectScheduleList(movno, schno);
    }

//    @Override
//    public MovieScheduleDTO readMovieSchedule() {
//        MovieScheduleDTO movschdto = new MovieScheduleDTO();
//        movschdto.setMovschlist(movdao.selectMovieSchdule());
//        movschdto.setMovtitle(movdao.selectMovieTitle());
//        movschdto.setBooked(movdao.selectBookedCnt()); // 예약된 좌석 현황 가져오기 등
//
//        return movschdto;
//    }


}

