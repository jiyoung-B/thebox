package com.team.thebox.repository;

import com.team.thebox.model.TicketMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketMovieRepository extends JpaRepository<TicketMovie, Long> {
    @Query(value = " select distinct ms.schno, ms.stime, m.movtitle, m.movgrade, m.movmainposter, m.movdetail " +
            " from movieschedule ms, movie m where ms.movno = m.movno " +
            " and ms.odate = :movdate and ms.ciplace = :district ", nativeQuery = true)
    List<Object[]> getMovieInfoByDistrictAndMovdate(@Param("district") String district, @Param("movdate") String movdate);
}
