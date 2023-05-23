package com.example.movie.Repository;

import com.example.movie.Model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query("SELECT a FROM Actor a  WHERE a.oscar = true")
    List<Actor> getActorsWithOscar();

    @Query("SELECT a FROM Actor a  WHERE a.gender = :gender")
    List<Actor> findActorByGender(@Param("gender") String gender);

    @Query("SELECT a FROM Actor a  WHERE a.oscar = :oscar AND a.gender = :gender ")
    List<Actor> getActorsWithOscarAndGender(@Param("oscar") String oscar,@Param("gender") String gende);






    //  @Query(value = "SELECT * FROM Actor ORDER BY  %:keyword%", nativeQuery = true)
   // List<Actor> findByKeyword(@Param("keyword") String keyword);

}
