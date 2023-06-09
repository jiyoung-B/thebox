package com.team.thebox.controller;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieReply;
import com.team.thebox.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired private MovieService movsrv;

        @GetMapping("/now")
        public ModelAndView now(){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("movie/now");
            Map<String, Object> movs = movsrv.readMovie();

            mv.addObject("mlist", movs.get("mlist") );

            return mv ;
        }
    @GetMapping("/all")
    public ModelAndView all(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("movie/all");
        Map<String, Object> movs = movsrv.readMovie();

        mv.addObject("mlist", movs.get("mlist") );

        return mv ;
    }

    @GetMapping("/readStar")
    public ModelAndView readStar(){
        ModelAndView mv = new ModelAndView();

        Map<String, Object> movs = movsrv.readStar();

        mv.addObject("mlist", movs.get("mlist") );
        mv.setViewName("movie/now");

        return mv ;
    }

    @GetMapping("/readTsales")
    public ModelAndView readTsales(){
        ModelAndView mv = new ModelAndView();

        List<Movie> movs = movsrv.readTsales();

        mv.addObject("mlist", movs );
        mv.setViewName("movie/now");

        return mv ;
    }

        @GetMapping("/soon")
        public String soon() {
            return "movie/soon";
        }

        @GetMapping("/view")
        public ModelAndView view(int movno){
            ModelAndView mv = new ModelAndView();
            mv.addObject("mov", movsrv.readOneMovie(movno));
            mv.addObject("rplist", movsrv.readOneMovieReply(movno));
            mv.setViewName("movie/view");
            return mv;
        }

        @PostMapping("/replyok")
        public String replyok(MovieReply reply){
            String viewPage = "error";

            if (movsrv.newReply(reply))
                viewPage = "redirect:/movie/view?movno=" + reply.getMovno();
            return viewPage;
        }

        @PostMapping("/modify") //댓글 수정
        public String modify( MovieReply reply){
            String viewPage = "error";
            if (movsrv.modifyReply(reply))
                viewPage = "redirect:/movie/view?movno=" + reply.getMovno();

            return viewPage;
        }


    @GetMapping("/delete")
    public String getDelete(Model m ,@RequestParam("rpno") int rpno, @RequestParam("movno") int movno) {

            movsrv.deleteReply(rpno);
            return "redirect:/movie/view?movno=" + movno;


}


}
