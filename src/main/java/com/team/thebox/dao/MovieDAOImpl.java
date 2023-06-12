package com.team.thebox.dao;

import com.team.thebox.dto.StarTDO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieReply;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.repository.*;
import com.team.thebox.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("movdao")
public class MovieDAOImpl implements MovieDAO {

    private final MovieRepository movieRepository;
    private final MovieAttachRepository movieAttachRepository;
    private final MovieReplyRepository movieReplyRepository;
    private final MovieScheduleRepository movieScheduleRepository;
    private final BookedRepository bookedRepository;
    private final MovieLocationRepository movieLocationRepository;
    private final TicketingRepository ticketingRepository;


    @Autowired
    public MovieDAOImpl(MovieRepository movieRepository, MovieAttachRepository movieAttachRepository,
                          MovieReplyRepository movieReplyRepository, MovieScheduleRepository movieScheduleRepository,
                          BookedRepository bookedRepository, MovieLocationRepository movieLocationRepository,
                          TicketingRepository ticketingRepository) {
        this.movieRepository = movieRepository;
        this.movieAttachRepository = movieAttachRepository;
        this.movieReplyRepository = movieReplyRepository;
        this.movieScheduleRepository = movieScheduleRepository;
        this.bookedRepository = bookedRepository;
        this.movieLocationRepository = movieLocationRepository;
        this.ticketingRepository = ticketingRepository;
    }


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
    @Override //all now soon
    public Map<String, Object> selectMovie() {
        Map<String, Object> movs = new HashMap<>();
        movs.put("mlist", movieRepository.findAllOrderBYMovreleasedateDesc() );
        return movs;
    }

    @Override
    public int insertMovieReply(MovieReply reply) {
        return  Math.toIntExact(movieReplyRepository.save(reply).getMovno() );
    }

    @Override
    public List<MovieReply> selectOneMovieReply(Long movno) {
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

    @Override   // 평점순
    public Map<String, Object> selectStar() {
//        Map<String, Object> movs = new HashMap<>();
//        movs.put("mlist", movieRepository.findStar() );
//        return movs;
        Map<String, Object> movs = new HashMap<>();
        List<Object[]> movieData = movieRepository.findMoviesOrderByAvgStarDesc();
        List<StarTDO> movieList = new ArrayList<>();

        for (Object[] data : movieData) {
            StarTDO starDto = new StarTDO();
            starDto.setMovno((Long) data[0]);
            starDto.setMovtitle((String) data[1]);
            starDto.setMovactor((String) data[2]);
            starDto.setMovgrade((String) data[3]);
            starDto.setMovreleasedate((String) data[4]);
            starDto.setMovmainposter((String) data[5]);
            starDto.setTsales((Double) data[6]);
            starDto.setAvgStar((Double) data[7]);
            movieList.add(starDto);
        }

        movs.put("mlist", movieList);
        return movs;
    }

    @Override
    public List<Movie> selectTsales() {
        return  movieRepository.findAllByOrderByTsalesDesc();
    }

    @Override
    public int updateReply(MovieReply reply) {
       // long rpno = movieReplyRepository.updateReply(reply.getReply(),reply.getStar(), reply.getRpno());
//        long rpno = movieReplyRepository.save(reply);
//        return (int) rpno;
        return Math.toIntExact(movieReplyRepository.save(reply).getMovno());
    }

    @Override
    public void deleteReply(int rpno) {
        movieReplyRepository.deleteById((long) rpno);
    }

    @Override
    public List<Movielocation> selectMovieLocation(){
        List<Movielocation> mvloc = movieLocationRepository.selectAll();

        return mvloc;
    }

    @Override
    public int insertTicket(Ticketing ticketing) {
        int result = Math.toIntExact((ticketingRepository.save(ticketing).getPmnumber()));

        return result;
    }

    @Override
    public List<TicketMovie> selectMovielist(Ticketing ticketing) {
        /*String district = ticketing.getDistrict();
        String movdate = ticketing.getMovdate();
        TicketMovie ticketMovie = new TicketMovie();
        ticketMovie.setDistrict(district);
        ticketMovie.setMovdate(movdate);

        Map<String, Object> movies = new HashMap<>();
        movies.put("movielist", TicketMovieRepository.findAllBy(district, movdate).getContent());
        System.out.println(movies.get("movielist"));*/


        return null;
    }

}
