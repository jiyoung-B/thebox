package com.team.thebox.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminMain(){
        //return "index.tiles";
        return "starter";

    }
    @GetMapping("/adminindex/chart")
    public String adminChart(){
        //return "index.tiles";
        return "uplot";

    }
    @GetMapping("/adminindex")
    public String adminIndex(){
        //return "index.tiles";
        return "adminindex";

    }


}
