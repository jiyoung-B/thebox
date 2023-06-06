package com.team.thebox.repository;

import com.team.thebox.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
//
//    @Query("SELECT m.movtitle FROM Movie m WHERE m.movno = :movno")
//    List<String> findMovTitleByMovno(@Param("movno") long movno);

    Movie findMovTitleByMovno(Long movno);

    @Query("SELECT m.movno, m.movtitle, m.movactor, m.movgrade,m.movreleasedate, AVG(r.star) AS avg_star " +
            "FROM Movie m JOIN MovieReply r ON m.movno = r.movno " +
            "GROUP BY m.movno, m.movtitle, m.movactor, m.movgrade, m.movreleasedate " +
            "ORDER BY avg_star DESC")
    Object findStar();
}
