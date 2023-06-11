package com.team.thebox.controller.admin;

import com.team.thebox.dto.MovieDTO;
import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.model.MovieStillcut;
import com.team.thebox.model.Movielocation;
import com.team.thebox.service.admin.AMovieScheduleService;
import com.team.thebox.service.admin.AMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/management/movie")
@Controller
public class AdminMovieController {
    @Autowired
    private AMovieService admmvsrv;
    @Autowired
    private AMovieScheduleService movschsrv;

    @GetMapping("/movielist")
    public String movieList(){

        return "management/movielist";
    }

    @GetMapping("/list")
    public ModelAndView list(Integer cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("management/movielist");
        if (cpg == null || cpg == 0) cpg = 1;

        // 자료실 게시글 읽어옴
        Map<String, Object> movs = admmvsrv.readMovie(cpg);


        mv.addObject("movlist", movs.get("movlist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", movs.get("cntpg"));

        return mv;
    }

    @GetMapping("/movieinforegister")
    public String showMovieInfoForm(Model m){
        m.addAttribute("movie", new Movie());

        return "management/movieinforegister";
    }

    @GetMapping("/register")
    public String showMovieForm(Model m){
        m.addAttribute("movie", new Movie());

        return "management/movieregister";
    }
    @PostMapping("/register")
    public String submitMovieForm(Movie movie, MultipartFile attach) throws IOException {
        String viewPage = "error";
        Map<String, Object> mvinfo = admmvsrv.newMovies(movie);

        if (!attach.isEmpty()) {
            admmvsrv.newMovieAttach(attach, mvinfo);
        }

        viewPage = "redirect:/management/movie/list";

        return viewPage;
    }


    @GetMapping("/view")
    public ModelAndView view(@RequestParam Long movno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("movie", admmvsrv.readOneMovie(movno));
        mv.setViewName("management/movieview");
        return mv;
    }

    // movie 수정화면 get
    // movie 수정화면 get
//    @GetMapping("/modify/{movno}")
//    public ModelAndView showModifyMovieForm(@PathVariable Long movno) {
//        Movie movie = amovdao.selectOneMovie(movno); // 영화 정보 불러오기
//        MovieStillcut stillcut = movie.getMovieStillcut(); // 스틸컷 정보 가져오기
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("management/movieedit");
//
//        mv.addObject("movie", movie);
//        mv.addObject("stillcut", stillcut); // 스틸컷 정보 추가
//        return mv;
//    }


    // movie 수정 post
    @PostMapping("/modify/{movno}")
    public String submitModifyMovie(@PathVariable Long movno, Movie updatemovie) {
        String viewPage = "error";

        Object existingmovie = admmvsrv.readOneMovie(movno);
        System.out.println("업데이트무비"+updatemovie);


        // 업데이트된 스케줄 정보 설정
//        existingmovie.setMovno(updatemovie.getMovno());
//        existingmovie.setMovtitle(updatemovie.getMovtitle());
//        existingmovie.setMovgenre(updatemovie.getMovgenre());
//        existingmovie.setMovdirector(updatemovie.getMovdirector());
//        existingmovie.setMovactor(updatemovie.getMovdetail());
//        existingmovie.setMovreleasedate(updatemovie.getMovreleasedate());
//        existingmovie.setMovgrade(updatemovie.getMovgrade());
//        existingmovie.setMovruntime(updatemovie.getMovruntime());
//        existingmovie.setMovdetail(updatemovie.getMovdetail());


        //if (admmvsrv.modifyMovieByMovno(existingmovie)) {
            viewPage = "redirect:/management/movie/list";
       // }
        return viewPage;

    }

    // 삭제
    @GetMapping("/remove/{movno}")
    public String removeMovie(@PathVariable Long movno) {
        if (admmvsrv.removeMovieByMovno(movno)) {
            return "redirect:/management/movie/list";
        } else {
            return "error";
        }

    }



    @GetMapping("/schedule/resgister")
    public String showScheduleForm(Model model){

        List<Movie> movies = admmvsrv.readMovnoAndTitle();
        System.out.println("스케줄등록"+movies);
        List<Movielocation> location = admmvsrv.readLocation();


        model.addAttribute("movies", movies); // 모델에 영화 리스트 추가
        model.addAttribute("location", location); // 모델에 영화 리스트 추가


        return "management/moviescheduleregister";

    }

    @PostMapping("/schedule/resgister")
    public String submitScheduleForm(MovieSchedule movsch){
        String viewPage = "error";
        if(admmvsrv.newMovieSchedule(movsch)){
            viewPage = "redirect:/management/movie/schedule/list";
        }

        return viewPage;

    }


    @GetMapping("/schedule/list")
    public ModelAndView  movieScheduleList() {
        ModelAndView mv = new ModelAndView();
        List<MovieScheduleDTO> movschlists = movschsrv.readMovieSchedule();
        mv.setViewName("management/movieschedulelist");
        mv.addObject("movschlists", movschlists);
        System.out.println("mov리스츠"+movschlists);

        return mv;

    }

    @GetMapping("/schedule/calendar")
    public String movieScheduleListCalendar(){
        return "management/movieschedulecalendar";

    }

    // 수정화면 get
    @GetMapping("/schedule/modify/{schno}")
    public ModelAndView modifyMovieScheduleForm(@PathVariable Long schno) {
        // 스케줄 정보 조회 예시
        MovieSchedule movsch = movschsrv.getOneMovieScheduleBySchno(schno);
        List<Movielocation> location = admmvsrv.readLocation();
        List<Movie> movies = admmvsrv.readMovnoAndTitle(); // 영화 제목 목록 가져오기

        ModelAndView mv = new ModelAndView();
        mv.setViewName("management/moviescheduleedit");
        mv.addObject("movsch", movsch);
        mv.addObject("location", location); // 모델에 영화 리스트 추가
        mv.addObject("movies", movies); // 모델에 영화 리스트 추가
        return mv;
    }

    // 수정 post
    @PostMapping("/schedule/modify/{schno}")
    public String modifyMovieSchedule(@PathVariable Long schno, MovieSchedule updateschedule) {
        String viewPage = "error";
        MovieSchedule existingschedule = movschsrv.getOneMovieScheduleBySchno(schno);

        // 업데이트된 스케줄 정보 설정
        existingschedule.setMovno(updateschedule.getMovno());
        existingschedule.setCiplace(updateschedule.getCiplace());
        existingschedule.setOdate(updateschedule.getOdate());
        existingschedule.setStime(updateschedule.getStime());
        existingschedule.setEtime(updateschedule.getEtime());
        existingschedule.setPrice(updateschedule.getPrice());

        if (movschsrv.modifyMovieScheduleBySchno(existingschedule)) {
            viewPage = "redirect:/management/movie/schedule/list";
        }
        return viewPage;

    }




    // 삭제
    @GetMapping("/schedule/remove/{schno}")
    public String removeMovieSchedule(@PathVariable Long schno) {
        if (movschsrv.removeMovieScheduleBySchno(schno)) {
            return "redirect:/management/movie/schedule/list";
        } else {
            return "error";
        }

    }


    @PostMapping("/movieinforegister")
    public String registerMovieInfo(@ModelAttribute MovieDTO movieDTO) {
        admmvsrv.registerMovieInfo(movieDTO);
        return "redirect:/management/movie/list";
    }




}
