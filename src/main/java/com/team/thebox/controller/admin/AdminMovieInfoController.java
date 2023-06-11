package com.team.thebox.controller.admin;

import com.team.thebox.dto.MovieRequestDto;
import com.team.thebox.dto.MovieDTO;
import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.model.MovieStillcut;
import com.team.thebox.service.admin.AMovieScheduleService;
import com.team.thebox.service.admin.AMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@CrossOrigin(originPatterns = "*")
@RequestMapping("/management/movieinfo")
@Controller
public class AdminMovieInfoController {
    @Autowired
    private AMovieService admmvsrv;
    @Autowired
    private AMovieScheduleService movschsrv;

    @GetMapping("/register")
    public String createMovie(Model model){
        //model.addAttribute("movieRequestDto", new MovieRequestDto());
        model.addAttribute("movie", new Movie());
        return "management/movieinforegi";
    }

    @PostMapping("/register")
    public String createMovieOK(Movie movie, List<MultipartFile> stillcuts){
        String viewPage = "error";

        if (!stillcuts.isEmpty()) {// 첨부파일이 존재한다면
            Map<String, Object> minfo = admmvsrv.newMovie(movie);
            admmvsrv.newMovieStillcut(stillcuts, minfo);
            viewPage = "redirect:/management/movieinfo/list";
        }
        return viewPage;

    }

    @GetMapping("/list")
    public String showAllMovie(Model model) {
        List<Movie> movies = admmvsrv.getAllMovies();
        model.addAttribute("movlist", movies);
        System.out.println("무비리스트"+ movies);
        return "management/movieinfolist";
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam Long movno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mov", admmvsrv.readOneMovie(movno));
        mv.setViewName("management/movieview");

        return mv;
    }

//    @GetMapping("/modify/{movno}")
//    public String showMovieForm(@PathVariable Long movno, Model model) {
//        Object movie = admmvsrv.readOneMovie(movno);
//        model.addAttribute("movie", movie);
//        return "management/movieview";
//    }
    @GetMapping("/modify/{movno}")
    public ModelAndView showModifyMovieForm(@PathVariable Long movno) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mov", admmvsrv.readOneMovie(movno));
        mv.setViewName("management/movieedit");
        return mv;
    }

//    @GetMapping("/modify/{movno}")
//    public String showModifyMovieForm(@PathVariable Long movno, Model model) {
//
//        Movie movie = admmvsrv.getMovieByMovno(movno);
//        model.addAttribute("무비뷰즈", movie);
//        System.out.println(movno);
//        //Object moviedetail = admmvsrv.readOneMovie(movno);
//
//
////        ModelAndView mv = new ModelAndView();
////        mv.setViewName("management/movieedit");
//
//
//        return "management/movieedit";
//    }



//    @PostMapping("/modify")
//    public String modifyMovieOK(Movie movie, List<MultipartFile> stillcuts) {
//        String viewPage = "error";
//
//        if (!stillcuts.isEmpty()) {
//            viewPage = admmvsrv.createMovieWithStillcuts(movie, stillcuts);
//        } else {
//            viewPage = admmvsrv.updateMovie(movie);
//        }
//
//        return viewPage;
//    }

    @GetMapping("/remove/{movno}")
    public String removeMovie(@PathVariable Long movno) {
        if (admmvsrv.removeMovieByMovno(movno)) {
            return "redirect:/management/movieinfo/list";
        } else {
            return "error";
        }

    }





}
