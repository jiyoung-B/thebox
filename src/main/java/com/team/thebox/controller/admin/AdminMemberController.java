package com.team.thebox.controller.admin;

import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.Member;
import com.team.thebox.service.admin.AMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/management/member")
@Controller
public class AdminMemberController {
    @Autowired
    private AMemberService admmemsrv;

    @GetMapping("/memberlist")
    public String memberList(Model model){
        List<Member> members = admmemsrv.getAllMembers();
        model.addAttribute("memlist", members);
        System.out.println("멤버리스트"+ members);
        return "management/memberlist";

    }

    @GetMapping("/ticketinglist")
    public String moviesTicketing(Model model){
        List<BookingDetails> bklist = admmemsrv.getAllBookedList();
        model.addAttribute("bklist", bklist);
        System.out.println("예약리스트"+ bklist);
        return "management/ticketinglist";

    }


}
