package com.example.movie.Controller;

import com.example.movie.Model.Film;
import com.example.movie.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/films/")
public class FilmController {

    @Autowired
   private FilmService filmService;

    @GetMapping("/all")
    public String getAllFilms(Model model){
        List<Film> listFilm = filmService.getFilm();
        model.addAttribute("listFilm", listFilm);
        return "film";
    }




}
