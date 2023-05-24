package com.team.thebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/management/movies")
@Controller
public class AdminMovieController {
    @GetMapping
    public String movieInfo(){
        return "management/movieRegister";
    }

    @GetMapping("/schedule")
    public String moviesSchedule(){
        return "management/movieSchedule";

    }


}
