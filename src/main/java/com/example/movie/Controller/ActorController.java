package com.example.movie.Controller;


import com.example.movie.Exception.RecordNotFoundException;
import com.example.movie.Model.Actor;
import com.example.movie.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller //sprawia ze ta klasa obsluguje punkty koncowe(getMapping itp)
@RequestMapping("/actors/")
    public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/list")
    public String getActor(
            @RequestParam(required = false) String columnName, Model model,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Boolean hasOscar
    ) {
        List<Actor> list = actorService.getActor();
        if (hasOscar != null && hasOscar){
            list = actorService.getActorOscar();
        }
        if (gender != null) {
            list = actorService.getActorByGender(gender);
        } else if (columnName != null) {
            list = actorService.sortByTitle(columnName);
        }
        model.addAttribute("list", list);
        return "actor";
    }


    @RequestMapping(path = "/delete/{ActorID}")
    public String deleteActorById(Model model, @PathVariable("ActorID") long ActorID) throws RecordNotFoundException {
        actorService.deleteById(ActorID);
        List<Actor> list = actorService.getActor();
        model.addAttribute("list", list);
        return "actor";
    }


    @GetMapping("/edit/{ActorID}")
    public String updateActor(Model model, @PathVariable("ActorID") long ActorID){
        model.addAttribute("actor", actorService.getActorById(ActorID));
        return "actor_edit";
    }

    @PostMapping("/actor/{ActorID}")
    public String updateActor(Model model, @PathVariable("ActorID") long ActorID, Actor actor){
       Actor editActor = actorService.getActorById(ActorID);

       editActor.setFirstname(actor.getFirstname());
       editActor.setLastname(actor.getLastname());
       editActor.setBirth(actor.getBirth());
       editActor.setGender(actor.getGender());
       editActor.setOscar(actor.isOscar());
       editActor.setScore(actor.getScore());

       actorService.updateActor(editActor);
       return "actor";
    }





}
