package com.example.movie.Repository;

import com.example.movie.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
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

    @Query("SELECT  a FROM Actor a ORDER BY a.score DESC")
    List<Actor> getTop10Actor();

    @Query(value = "SELECT * FROM Actor a where a.firstname like %:keyword% OR a.lastname like %:keyword% OR a.score like %:keyword% OR a.oscar like %:keyword% OR a.ActorID like %:keyword% OR a.birth like %:keyword% OR a.gender like %:keyword% ", nativeQuery = true)
    List<Actor> findByKeyword(@Param("keyword") String keyword);





}
