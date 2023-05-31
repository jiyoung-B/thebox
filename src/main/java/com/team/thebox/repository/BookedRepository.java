package com.team.thebox.repository;

import com.team.thebox.model.Booked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookedRepository extends JpaRepository<Booked, Long> {
    @Query("SELECT COUNT(seatid) FROM Booked ")
    int countTotalSeatIds();
}
