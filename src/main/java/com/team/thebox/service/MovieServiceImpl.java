package com.team.thebox.service;

import com.team.thebox.dao.MovieDAO;
import com.team.thebox.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("movsrv")
public class MovieServiceImpl implements MovieService {

    @Autowired private MovieDAO movdao;

    @Override//now
    public Map<String, Object> readMovie() {
        return movdao.selectMovie();
    }

    @Override
    public Movie readOneMovie(int movno) {
        return movdao.selectOneMovie(movno);
    }

    @Override
    public boolean newReply(MovieReply reply) {
        boolean result = false;

        if (movdao.insertMovieReply(reply) > 0) result=true;
        return result;
    }

    @Override
    public List<MovieReply> readOneMovieReply(Long movno) {
        return movdao.selectOneMovieReply(movno);
    }

    @Override   //댓글 수정
    public boolean modifyReply(MovieReply reply) {
        boolean result = false;
        if (movdao.updateReply(reply) > 0) result = true;

        return result;
    }

    @Override
    public void deleteReply(int rpno) {
        movdao.deleteReply(rpno);
    }

    @Override
    public Map<String, Object> readStar() {
        return movdao.selectStar();
    }

    @Override
    public List<Movielocation> readMovieLocation() {
        return movdao.selectMovieLocation();
    }

    @Override
    public boolean newTicket(Ticketing ticketing) {
        System.out.println("service : "+ticketing);
        boolean result = false;
        if(movdao.insertTicket(ticketing)>0) result = true;

        return result;
    }

    @Override
    public String readMovielist(Ticketing ticketing) {
        return movdao.selectMovielist(ticketing);
    }

    @Override
    public void newBooking(BookingDetails bds) {
        movdao.insertBooking(bds);
    }

    @Override
    public List<Movie> readTsales() {
        return movdao.selectTsales();
    }
}
