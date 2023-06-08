package com.team.thebox.repository;

import com.team.thebox.model.Movielocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieLocationRepository extends JpaRepository<Movielocation, Long> {
    @Query(value = "select LOCATIONNUM, DISTRICTNAME, PLACENAME from movielocation order by LOCATIONNUM", nativeQuery = true)
    List<Movielocation> selectAll();
}
