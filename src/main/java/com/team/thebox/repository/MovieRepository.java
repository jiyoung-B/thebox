package com.team.thebox.repository;

import com.team.thebox.model.Movie;
import com.team.thebox.model.Movielocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
//
//    @Query("SELECT m.movtitle FROM Movie m WHERE m.movno = :movno")
//    List<String> findMovTitleByMovno(@Param("movno") long movno);

    Movie findMovTitleByMovno(Long movno);

}
