package com.example.movie.Service;

import com.example.movie.Model.Actor;
import com.example.movie.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


import java.util.Collections;
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



    /*
    public Page<Actor> findPaginated(Pageable pageable) {
        List<Actor> allActors = actorRepository.findAll();

        int pageSize = pageable.getPageSize();;
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage*pageSize;
        List<Actor> list;

        if (allActors.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, allActors.size());
            list = allActors.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, pageable, allActors.size());
    }

     */






}
