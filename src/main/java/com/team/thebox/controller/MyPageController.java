package com.team.thebox.controller;

import com.team.thebox.model.CancellationDetails;
import com.team.thebox.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;
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
    public ModelAndView MyTicket(String userid, String title) throws MalformedURLException {
        ModelAndView mv = new ModelAndView();

        Map<String, Object> bds = mpsrv.readBookingDetails(userid);
        Map<String, Object> cds = mpsrv.readCancellationDetails(userid);
        Map<String, Object> pst = mpsrv.readPoster(userid);

        List<UrlResource> poster = Collections.singletonList(new UrlResource("file:" + "C:/Java/Posters/" + pst));

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cdlist", cds.get("cdlist"));
        mv.addObject("pstUrl", poster);

        mv.setViewName("mypage/myticket");

        return mv;
    }

    @GetMapping("/showimg")
    @ResponseBody
    public Resource showPoster(String title) throws MalformedURLException {
        String poster = "C:/Java/Posters/" + title + ".jpg";

        return new UrlResource("file:" + poster);
    }

    @PostMapping("/myticket")
    public String MyTicketDelNIns(int bkno, CancellationDetails cds) {

        mpsrv.rmBkNnewCan(bkno, cds);

        return "mypage/myticket";
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
