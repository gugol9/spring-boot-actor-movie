package com.example.movie.Repository;

import com.example.movie.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {


    //oscar
    @Query("SELECT a FROM Actor a  WHERE a.oscar = true")
    List<Actor> findActorByOscar();

}
