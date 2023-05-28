package com.team.thebox.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/management/movie")
@Controller
public class AdminMovieController {
    @GetMapping("/movielist")
    public String movieList(){

        return "management/movielist";
    }
    @GetMapping("/register")
    public String movieRegister(){

        return "management/movieregister";
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
