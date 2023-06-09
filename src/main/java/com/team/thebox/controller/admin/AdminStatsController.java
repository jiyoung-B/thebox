package com.team.thebox.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management/stats")
public class AdminStatsController {

    @GetMapping("/sales")
    public String sales() {

        return "management/sales";
    }

    @GetMapping("/chart")
    public String numeration() {

        return "management/chart";
    }
}
