package com.example.movie.Service;

import com.example.movie.Exception.RecordNotFoundException;
import com.example.movie.Model.Actor;
import com.example.movie.Model.Film;
import com.example.movie.Repository.ActorRepository;
import com.example.movie.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getActor(){
        List<Actor> list = (List<Actor>)actorRepository.findAll();
        return list;
    }

    public List<Actor> getActorOscar(){
        return  actorRepository.getActorsWithOscar();
    }

    public List<Actor> sortByTitle(String columnName){
        Sort sort = Sort.by(columnName).ascending();
        return actorRepository.findAll(sort);
    }

    public List<Actor> getActorByGender(String gender){
        return actorRepository.findActorByGender(gender);
    }

    public void deleteById(Long id){
        actorRepository.deleteById(id);
    }

}


/*   public List<Actor> getActorByOscarAndGender( String gender, boolean oscar){
        return actorRepository.getActorsWithOscarAndGender(gender, String.valueOf(oscar));
    }

 */