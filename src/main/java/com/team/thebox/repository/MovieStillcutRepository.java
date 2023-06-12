package com.team.thebox.repository;

import com.team.thebox.model.MovieList;
import com.team.thebox.model.MovieStillcut;
import com.team.thebox.model.MovieView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieStillcutRepository extends JpaRepository<MovieStillcut, Long> {
    List<MovieList> findAllBy();
    MovieView findAllByMovno(Long movno);


    void deleteByMovno(Long movno);





    @Modifying
    @Query("UPDATE MovieStillcut ms SET ms.fname = :fname, ms.fsize = :fsize WHERE ms.movno = :movno")
    void updateMovieStillcut(
            @Param("fname") String fname,
            @Param("fsize") String fsize,
            @Param("movno") Long movno
    );
}
