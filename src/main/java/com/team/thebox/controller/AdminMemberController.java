package com.team.thebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/management/member")
@Controller
public class AdminMemberController {

    @GetMapping("/memberlist")
    public String moviesSchedule(){
        return "management/memberlist";

    }

    @GetMapping("/ticketinglist")
    public String moviesTicketing(){
        return "management/ticketinglist";

    }


}
