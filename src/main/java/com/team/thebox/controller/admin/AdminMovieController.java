package com.team.thebox.controller.admin;

import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.service.admin.MovieScheduleService;
import com.team.thebox.service.admin.MovieService;
import com.team.thebox.service.admin.MovieServiceImpl;
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
    private MovieService admmvsrv;
    @Autowired
    private MovieScheduleService movschsrv;

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
    public String view(@RequestParam int movno, Model m){

        m.addAttribute("movie", admmvsrv.readOneMovie(movno));

        return "management/movieview";
    }


    @GetMapping("/schedule/resgister")
    public String showScheduleForm(Model model){

        List<Movie> movies = admmvsrv.readMovnoAndTitle();

        model.addAttribute("movies", movies); // 모델에 영화 리스트 추가


        return "management/moviescheduleregister";

    }

    @PostMapping("/schedule/resgister")
    public String submitScheduleForm(MovieSchedule movsch){
        String viewPage = "error";
        if(admmvsrv.newMovieSchedule(movsch)){
            viewPage = "redirect:/management/movie/schedule";
        }

        return viewPage;

    }


    @GetMapping("/schedule/list")
    public ModelAndView  movieScheduleList() {
        List<MovieScheduleDTO> scheduleList = new ArrayList<>();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("management/movieschedulelist");

        List<MovieScheduleDTO> movschlists = movschsrv.readMovieSchedule();


        mv.addObject("movschlists", movschlists);
        System.out.println("mov리스츠"+movschlists);
//        System.out.println("mov리스트"+movschlists.get("movschlist"));
//        System.out.println("mov타이틀"+movschlists.get("movtitle"));
//        System.out.println("mov북트"+movschlists.get("booked"));


        return mv;

    }


//    @GetMapping("/schedule/list")
//    public ModelAndView movieScheduleList(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("management/movieschedulelist");
//
//        // 영화스케줄 가져오기
//        MovieScheduleDTO movschdto = admmvsrv.readMovieSchedule();
//        // 영화스케줄의 movno 와 매칭된 영화 제목 읽어오기
////        List<String> movtitle = admmvsrv.readMovieTitle();
//        // 영화스케줄 schno와 매칭된 예약된 좌석현황 (seatid count) 가져오기
//
//        //이걸 한번에 돌려줘야하는데...
//
//        mv.addObject("movschdto", movschdto);
//
//        System.out.println("디티오"+movschdto);
//        System.out.println("디티오Movschlist"+movschdto.getMovschlist());
//        System.out.println("디티오Movtitle"+movschdto.getMovtitle());
//        System.out.println("디티오Booked"+movschdto.getBooked());
//
//        return mv;
//
//    }

    @GetMapping("/schedule/calendar")
    public String movieScheduleListCalendar(){
        return "management/movieschedulecalendar";

    }


}
