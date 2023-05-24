package com.example.movie.Controller;

import com.example.movie.DTO.FilmRatingDTO;
import com.example.movie.Model.Actor;
import com.example.movie.Service.ActorService;
import com.example.movie.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FilmRatingController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private FilmService filmService;


    @GetMapping("/top")
    public String getTop(Model model){
        List<Actor> actorList = actorService.getTop10Actor();
        List<FilmRatingDTO> dtoList = filmService.getTop10Film();
        model.addAttribute("topActors", actorList);
        model.addAttribute("topFilms", dtoList);
        return "index";
    }
}
