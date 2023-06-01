package com.team.thebox.repository;

import com.team.thebox.model.Booked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookedRepository extends JpaRepository<Booked, Long> {
//    @Query("SELECT COUNT(seatid) FROM Booked where schno ")
//    List<Integer> countTotalSeatIds();
//
//    @Query("SELECT COUNT(b.seatid) FROM Booked b WHERE b.schno = :schno")
//    Integer countTotalSeatIds(@Param("schno") Long schno);

    @Query("SELECT COUNT(b.seatid) FROM Booked b ")
    List<Integer> countTotalSeatIds();


//    @Query("SELECT COUNT(b.seatid) FROM Booked b WHERE b.schno = :schno")
    int countTotalSeatIdsBySchno(Long schno); /*@Param("schno")*/

}
