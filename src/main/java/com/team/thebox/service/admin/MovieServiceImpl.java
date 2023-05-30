package com.team.thebox.service.admin;

import com.team.thebox.dao.MovieDAO;
import com.team.thebox.dao.MovieDAOImpl;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.utils.PdsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.HashMap;
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
    public Movie readOneMovie(int mvno) {
        return movdao.selectOneMovie(mvno);
    }

    @Override
    public Map<String, Object> readMovie(Integer cpg) {
        return movdao.selectMovie(cpg - 1);
    }
}

