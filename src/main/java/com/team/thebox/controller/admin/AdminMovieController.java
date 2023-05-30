package com.team.thebox.controller.admin;

import com.team.thebox.model.Movie;
import com.team.thebox.service.admin.MovieService;
import com.team.thebox.service.admin.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RequestMapping("/management/movie")
@Controller
public class AdminMovieController {
    @Autowired
    private MovieService admmvsrv;
    @GetMapping("/movielist")
    public String movieList(){

        return "management/movielist";
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

//        if (!attach.isEmpty()) {
//            admmvsrv.newMovieAttach(attach, mvinfo);
//        }

        viewPage = "redirect:/management/movielist";


        return viewPage;
    }

    @GetMapping("/schedule/resgister")
    public String movieScheduleRegister(){
        return "management/moviescheduleregister";

    }

    @GetMapping("/schedule")
    public String movieScheduleList(){
        return "management/movieschedulelist";

    }
    @GetMapping("/schedule/calendar")
    public String movieScheduleListCalendar(){
        return "management/movieschedulecalendar";

    }


}
