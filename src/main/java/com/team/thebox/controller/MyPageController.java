package com.team.thebox.controller;

import com.team.thebox.model.Member;
import com.team.thebox.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private MypageService mpsrv;

    @GetMapping("/mymoti")
    public ModelAndView MyMoti(String userid) {

        ModelAndView mv = new ModelAndView();
        Map<String, Object> bds = mpsrv.readBookingDetails(userid);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("mp", mpsrv.readOneMember(userid));
        mv.setViewName("mypage/mymoti");

        return mv;
    }

    @GetMapping("/myticket")
    public ModelAndView MyTicket(String userid) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> bds = mpsrv.readBookingDetails(userid);
        Map<String, Object> cds = mpsrv.readCancellationDetails(userid);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cdlist", cds.get("cdlist"));
        mv.setViewName("mypage/myticket");

        return mv;

    }

    @GetMapping("/modify")
    public ModelAndView Modify(String userid) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("mp", mpsrv.readOneMember(userid));
        mv.setViewName("mypage/modify");

        return mv;
    }
}
