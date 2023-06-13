package com.team.thebox.controller.admin;

import com.team.thebox.service.admin.AStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/management/stats")
public class AdminStatsController {

    @Autowired
    AStatsService assrv;

    @GetMapping("/sales")
    public ModelAndView sales() {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> t5sales = assrv.readTop5Sales();
        Map<String, Object> t5share = assrv.readTop5Share();

        mv.addObject("t5salist", t5sales.get("t5salist"));
        mv.addObject("t5shlist", t5share.get("t5shlist"));

        mv.setViewName("management/sales");

        return mv;
    }

    @GetMapping("/chart")
    public ModelAndView chart() {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> t5d = assrv.readTop5Date();
        Map<String, Object> t5c = assrv.readTop5Cmbo();

        mv.addObject("t5dlist", t5d.get("t5dlist"));
        mv.addObject("t5clist", t5c.get("t5clist"));

        mv.setViewName("management/chart");

        return mv;
    }
}
