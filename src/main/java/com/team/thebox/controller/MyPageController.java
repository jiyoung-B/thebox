package com.team.thebox.controller;

import com.team.thebox.model.Member;
import com.team.thebox.service.MypageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private MypageService mpsrv;

    @GetMapping("/mymoti")
    public ModelAndView MyMoti(String userid) {

        ModelAndView mv = new ModelAndView();
        Map<String, Object> t2s = mpsrv.readTop2(userid);

        mv.addObject("t2list", t2s.get("t2list"));
        mv.addObject("mp", mpsrv.readOneMember(userid));
        mv.setViewName("mypage/mymoti");

        return mv;
    }

    @GetMapping("/myticket")
    public ModelAndView MyTicket(String userid, String title, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();

//        Map<String, Object> imgs = mpsrv.readPoster(title);


        Map<String, Object> bds = mpsrv.readBookingDetails(userid);
        Map<String, Object> cds = mpsrv.readCancellationDetails(userid);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cdlist", cds.get("cdlist"));
//        mv.addObject("imgs", imgs.get("imgs"));

        mv.setViewName("mypage/myticket");

        return mv;

    }

    @ResponseBody
    @GetMapping("/image")
    public void zipcode(String title, HttpServletResponse res) {
        try {
            res.setContentType("application/json; charset=UTF-8");
            res.getWriter().print(mpsrv.readPoster(title));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/modify")
    public ModelAndView Modify(String userid) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("mp", mpsrv.readOneMember(userid));
        mv.setViewName("mypage/modify");

        return mv;
    }

    @PostMapping("/modify")
    public ModelAndView ModifyUpdate(String userid, String fillEmail, String changePhnum, String newPswd2) {
        ModelAndView mv = new ModelAndView();

        if (fillEmail != null) mpsrv.modifyEmail(userid, fillEmail);
        if (changePhnum != null) mpsrv.modifyPhnum(userid, changePhnum);
        if (newPswd2 != null) mpsrv.modifynewPswd(userid, newPswd2);

        mv.addObject("mp", mpsrv.readOneMember(userid));
        mv.setViewName("mypage/modify");

        return mv;
    }

    @GetMapping("/goodbye")
    public String goodbye() {

        return "mypage/goodbye";
    }

    @PostMapping("/goodbye")
    public String goodbyeok(String userid) {

        mpsrv.removeMember(userid);

        return "mypage/goodbye";
    }
}
