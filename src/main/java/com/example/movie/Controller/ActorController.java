package com.example.movie.Controller;

import com.example.movie.Exception.RecordNotFoundException;
import com.example.movie.Model.Actor;
import com.example.movie.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller //sprawia ze ta klasa obsluguje punkty koncowe(getMapping itp)
@RequestMapping("/actors/")
    public class ActorController {

    @Autowired
    private ActorService actorService;

    //top 10 aktorow
    @GetMapping("/top10")
    public String top10(Model model){
        List<Actor> list = actorService.getTop10Actor();
        model.addAttribute("top10Actors",list);
        return "index";
    }

    @GetMapping("/list")
    public String getActor(
            @RequestParam(required = false) String columnName, Model model,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Boolean hasOscar
    ) {
        List<Actor> list = actorService.getAllActors();
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

    @GetMapping(path = "/delete/{ActorID}")
    public String deleteActorById(Model model, @PathVariable("ActorID") long ActorID) throws RecordNotFoundException {
        actorService.deleteById(ActorID);
        List<Actor> list = actorService.getAllActors();
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


    @GetMapping("/search")
    public String searchActorByKeyWord(Model model, String keyword){
        List<Actor> list;
        if (keyword !=  null){
            list = actorService.findByKeyword(keyword);
        }else {
            list = actorService.getAllActors();
        }
        model.addAttribute("search", list);
        return "search";
    }

    //kontroler jest odpowiedzialna za wyświetlanie formularza do dodawania nowego studenta.
    @GetMapping("/create/add")
    public String createActor(Model model){
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "add_actor";
    }

    // Post actor
    @PostMapping("/create")
    public String saveActor(@ModelAttribute("actor") Actor actor){
        actorService.addActor(actor);
        return "actor";
    }
}
