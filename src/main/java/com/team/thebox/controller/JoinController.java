package com.team.thebox.controller;

import com.team.thebox.model.Member;
import com.team.thebox.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired private JoinService jnsrv;

    @GetMapping("/signup")
    public String signup(Model m){
        m.addAttribute("member", new Member());
        return "join/signup";
    }

    @PostMapping("/signup")
    public String signupok(@Valid Member member, BindingResult br){
        String viewPage = "redirect:/";

        if (br.hasErrors())
            viewPage = "join/signup";
        else {
            jnsrv.newMember(member);
        }

        return viewPage;
    }

    @ResponseBody
    @GetMapping("/checkuid")
    public void checkuid(String uid, HttpServletResponse res) {
        try {
            // 아이디 사용여부를 뷰없이 바로 응답으로 출력
            res.getWriter().print( jnsrv.checkUserid(uid) );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
