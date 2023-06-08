package com.team.thebox.controller;

import com.team.thebox.model.MovieSelect;
import com.team.thebox.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired private MovieService movsrv;

    @GetMapping("/ticketing")
    public String buyticket() {
        return "ticket/ticketing";
    }

    @GetMapping("/locationSelect")
    public ModelAndView ticketSub01() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ticket/locationSelect");
        mv.addObject("loclist", movsrv.readMovieLocation());

        return mv;
    }

    @GetMapping("/dateSelect")
    public String ticketSub02(Model m) {
        LocalDateTime ldt = LocalDateTime.now();
        String today = String.valueOf(ldt).substring(0, 10);

        m.addAttribute("today", today);
        return "ticket/dateSelect";
    }

    @GetMapping("/movieSelect")
    public String ticketSub03() {
        return "ticket/movieSelect";
    }

    @PostMapping("/movieSelect")
    public String ticketSub03(Model m) {
        m.addAttribute("movieSelect", new MovieSelect());
        return "ticket/movieSelect";
    }

    @GetMapping("/priceSelect")
    public String ticketSub04() {
        return "ticket/priceSelect";
    }

    @GetMapping("/seatSelect")
    public String buyticket2() {return "ticket/seatSelect";}
}
