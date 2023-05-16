package com.example.movie.Service;

import com.example.movie.Actor;
import com.example.movie.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
