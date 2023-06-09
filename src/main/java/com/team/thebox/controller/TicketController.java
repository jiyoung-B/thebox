//package com.team.thebox.controller;
//
//import com.siot.IamportRestClient.IamportClient;
//import com.siot.IamportRestClient.exception.IamportResponseException;
//import com.siot.IamportRestClient.response.IamportResponse;
//import com.siot.IamportRestClient.response.Payment;
//import com.team.thebox.model.MovieSelect;
//import com.team.thebox.model.Ticketing;
//import com.team.thebox.service.MovieService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Locale;
//
//@Controller
//@RequestMapping("/ticket")
//public class TicketController {
//    @Autowired private MovieService movsrv;
//    private IamportClient api;
//
//    @GetMapping("/ticketing")
//    public String buyticket() {
//        return "ticket/ticketing";
//    }
//
//    @PostMapping("/ticketing")
//    public String buyticket3(Ticketing ticketing, HttpSession sess) {
//        System.out.println("controller : 1");
//        if(sess.getAttribute("UID")==null) {
//        } else {
//            ticketing.setUserid(sess.getAttribute("UID").toString());
//            System.out.println("controller : "+ticketing);
//            System.out.println(movsrv.newTicket(ticketing));
//        }
//        return null;
//    }
//
//    @GetMapping("/locationSelect")
//    public ModelAndView ticketSub01() {
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("ticket/locationSelect");
//        mv.addObject("loclist", movsrv.readMovieLocation());
//
//        return mv;
//    }
//
//    @GetMapping("/dateSelect")
//    public String ticketSub02(Model m) {
//        LocalDateTime ldt = LocalDateTime.now();
//        String today = String.valueOf(ldt).substring(0, 10);
//
//        m.addAttribute("today", today);
//        return "ticket/dateSelect";
//    }
//
//    @GetMapping("/movieSelect")
//    public String ticketSub03() {
//        return "ticket/movieSelect";
//    }
//
//    @PostMapping("/movieSelect")
//    public String ticketSub03(Model m) {
//        m.addAttribute("movieSelect", new MovieSelect());
//        return "ticket/movieSelect";
//    }
//
//    @GetMapping("/priceSelect")
//    public String ticketSub04() {
//        return "ticket/priceSelect";
//    }
//
//    @GetMapping("/seatSelect")
//    public String buyticket2() {return "ticket/seatSelect";}
//
//    public TicketController() {
//        // REST API 키와 REST API secret 를 아래처럼 순서대로 입력한다.
//        this.api = new IamportClient("5417181408372670","fR29EGuFbKeEn7WtDW47RDWjK29DOfL2TVBuZ2RdYoYyKv6xXn6zlIICycfNFwynfV7hz3G9qAB3Mfed");
//    }
//
//    @ResponseBody
//    @RequestMapping(value="/verifyIamport/{imp_uid}")
//    public IamportResponse<Payment> paymentByImpUid(
//            Model model
//            , Locale locale
//            , HttpSession session
//            , @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException
//    {
//        return api.paymentByImpUid(imp_uid);
//    }
//}
