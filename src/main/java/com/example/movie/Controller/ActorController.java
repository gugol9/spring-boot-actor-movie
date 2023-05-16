package com.example.movie.Controller;


import com.example.movie.Actor;
import com.example.movie.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller //sprawia ze ta klasa obsluguje punkty koncowe(getMapping itp)

    public class ActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping("/")
    public String home(Actor actor, Model model){
        List<Actor> list = actorService.getActor();
        model.addAttribute("list",list);
        return "actor";
    }

//    @GetMapping("/name")
//    public String home(Model model){
//        model.addAttribute("name", "Przemek");
//        return "home";
//    }
}
