package com.team.thebox.controller.admin;

import com.team.thebox.dto.MovieRequestDto;
import com.team.thebox.dto.MovieDTO;
import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.service.admin.AMovieScheduleService;
import com.team.thebox.service.admin.AMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("/management/movieinfo")
@Controller
public class AdminMovieInfoController {
    @Autowired
    private AMovieService admmvsrv;
    @Autowired
    private AMovieScheduleService movschsrv;

    @GetMapping("/register")
    public String CreateMovie(Model model){
        model.addAttribute("movieRequestDto", new MovieRequestDto());
        return "management/movieinforegi";
    }

    @PostMapping("/register")
    public String createMovie(MovieRequestDto movieRequestDto){
        System.out.println("movieRequestDto = " + movieRequestDto);
        admmvsrv.createMovie(movieRequestDto);
        return "movie/view"; // 영화 상세페이지로 이동
    }



}
