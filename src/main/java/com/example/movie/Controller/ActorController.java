package com.example.movie.Controller;


import com.example.movie.Model.Actor;
import com.example.movie.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller //sprawia ze ta klasa obsluguje punkty koncowe(getMapping itp)

    public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/actor")
    public String getActor(
            @RequestParam(required = false) String columnName, Model model,
            @RequestParam(required = false) String gender
    ) {
        List<Actor> list = actorService.getActor();
        if (gender != null) {
            list = actorService.getActorByGender(gender);
        } else if (columnName != null) {
            list = actorService.sortByTitle(columnName);
        }
        model.addAttribute("list", list);


        return "actor";
    }


    //nie dziala
    @GetMapping("/actor/oscar")
        public String getOscar(
            Model model){

        actorService.getActor();
        List<Actor> list;
            list = actorService.getActorOscar();

        model.addAttribute("list", list);
        return "actor";

    }







}
