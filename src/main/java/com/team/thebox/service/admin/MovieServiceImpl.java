package com.team.thebox.service.admin;

import com.team.thebox.dao.MovieDAO;
import com.team.thebox.dao.MovieDAOImpl;
import com.team.thebox.model.Movie;
import com.team.thebox.utils.PdsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service("admmvsrv")
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieDAO movdao;
    @Autowired
    PdsUtils pdsUtils;

    @Override
    public Map<String, Object> newMovies(Movie movie) {


        int movno = movdao.insertMovie(movie);    // 폼 데이터 디비에 저장

        // 첨부파일을 시스템에 저장할때 사용할 정보를 Map에 저장
        Map<String, Object> mvinfo = new HashMap<>();
        mvinfo.put("movno", movno);


        return mvinfo;

    }

    @Override
    public boolean newMovieAttach(MultipartFile attach, Map<String, Object> pinfo) {
        return false;
    }
}

