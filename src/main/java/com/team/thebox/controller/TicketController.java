package com.team.thebox.controller;

import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.team.thebox.model.Ticketing;
import com.team.thebox.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired private MovieService movsrv;
    private IamportClient api;

    @GetMapping("/ticketing")
    public String buyticket() {
        return "ticket/ticketing";
    }

    @PostMapping("/ticketing")
    public String buyticket3(Ticketing ticketing, HttpSession sess) {
        String viewName = "ticket/ticketing";
        if(sess.getAttribute("UID")==null) {
        } else {
            ticketing.setUserid(sess.getAttribute("UID").toString());
            if(movsrv.newTicket(ticketing))viewName = "redirect:mypage/myticket";

        }
        return viewName;
    }

    @GetMapping("/locationSelect")
    public ModelAndView ticketSub01() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ticket/locationSelect");
        mv.addObject("loclist", movsrv.readMovieLocation());

        return mv;
    }

    @GetMapping("/dateSelect")
    public String ticketSub02(Model m) {
        LocalDateTime ldt = LocalDateTime.now();
        String today = String.valueOf(ldt).substring(0, 10);

        m.addAttribute("today", today);
        return "ticket/dateSelect";
    }

    @GetMapping("/movieSelect")
    public String ticketSub03() {
        return "ticket/movieSelect";
    }

    @GetMapping("/priceSelect")
    public String ticketSub04() {
        return "ticket/priceSelect";
    }

    @GetMapping("/seatSelect")
    public String buyticket2() {return "ticket/seatSelect";}

    public TicketController() {
        this.api = new IamportClient("5417181408372670","fR29EGuFbKeEn7WtDW47RDWjK29DOfL2TVBuZ2RdYoYyKv6xXn6zlIICycfNFwynfV7hz3G9qAB3Mfed");
    }

    @ResponseBody
    @RequestMapping(value="/verifyIamport/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(
            Model model
            , Locale locale
            , HttpSession session
            , @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException
    {
        return api.paymentByImpUid(imp_uid);
    }


    @ResponseBody
    @RequestMapping(value="/loadMovielist")
    public String loadMovielist(@RequestBody String test01) {
        Gson gson = new Gson();
        Ticketing ticketing = gson.fromJson(test01, Ticketing.class);
        System.out.println("ticketing : "+ticketing);
        String test = movsrv.readMovielist(ticketing);

        return test;
    }
}
