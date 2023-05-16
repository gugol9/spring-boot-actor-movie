package com.example.movie.Controller;


import com.example.movie.Model.Actor;
import com.example.movie.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller //sprawia ze ta klasa obsluguje punkty koncowe(getMapping itp)

    public class ActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping("/actor")
    public String home(Actor actor, Model model){
        List<Actor> list = actorService.getActor();
        model.addAttribute("list",list);
        return "actor";
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Przemek");
        return "home";
    }

    @GetMapping("/oscar")
    public String oscar(Actor actor, Model model){
        List<Actor> list = actorService.getActorOscar();
        model.addAttribute("list",list);
        return "oscar";
    }


}
