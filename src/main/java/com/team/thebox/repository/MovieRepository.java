package com.team.thebox.repository;

import com.team.thebox.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m.movtitle FROM MovieSchedule ms JOIN Movie m ON ms.movno = m.movno")
    List<String> findMovTitleByMovno();
//    @Query(value =" select movtitle, movno from movie ", nativeQuery = true)
//    List<Movie> findAllMovnoAndMovtitle();


//    @Query("SELECT m.movtitle FROM Movie m")
//    List<String> findAllMovtitle();

//    @Query("SELECT DISTINCT m.movtitle FROM Movie m")
//    List<String> findAllDistinctMovtitle();
}
