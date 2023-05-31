package com.example.movie.Service;

import com.example.movie.Model.Actor;
import com.example.movie.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

import java.util.List;
import java.util.Optional;
=======
import java.util.List;
>>>>>>> development


@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

<<<<<<< HEAD
=======

>>>>>>> development
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
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

    public void updateActor(Actor actor){
        actorRepository.save(actor);
    }
<<<<<<< HEAD
=======

    public Actor getActorById(Long actorID) {
       return  actorRepository.findById(actorID).get();
    }
>>>>>>> development

    public Actor getActorById(Long actorID) {
       return  actorRepository.findById(actorID).get();
    }

<<<<<<< HEAD

=======
    //ZLE UZYCIE DAO
>>>>>>> development
    public List<Actor> getTop10Actor() {
       return actorRepository.getTop10Actor()
               .stream()
               .limit(10)
               .toList();
<<<<<<< HEAD
    }

    public List<Actor> findByKeyword(String keyWord){
        return actorRepository.findByKeyword(keyWord);
=======
>>>>>>> development
    }
}

<<<<<<< HEAD
=======
    public List<Actor> findByKeyword(String keyWord){
        return actorRepository.findByKeyword(keyWord);
    }

    public void addActor(Actor actor){
        actorRepository.save(actor);
    }
}

>>>>>>> development
