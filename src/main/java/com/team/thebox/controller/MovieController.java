package com.team.thebox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

        @GetMapping("/now")
        public String now() {
            return "movie/now";
        }

        @GetMapping("/soon")
        public String soon() {
            return "movie/soon";
        }


}
