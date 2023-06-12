package com.team.thebox.repository;

import com.team.thebox.model.Movielocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieLocationRepository extends JpaRepository<Movielocation, Long> {
    @Query(value = "select LOCATIONNUM, DISTRICTNAME, PLACENAME from movielocation order by LOCATIONNUM", nativeQuery = true)
    List<Movielocation> selectAll();

    @Query(value = "SELECT LOCATIONNUM, DISTRICTNAME, PLACENAME FROM movielocation WHERE LOCATIONNUM = :ciplace", nativeQuery = true)
    Movielocation findDistrictNameByLocationNum(@Param("ciplace") Long ciplace);

    @Query(value = "SELECT distinct LOCATIONNUM FROM movielocation WHERE DISTRICTNAME = :district", nativeQuery = true)
    Long findDistrictNameByLocationName(@Param("district") String district);

}
