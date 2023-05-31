package com.team.thebox.repository;

import com.team.thebox.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingdetailsRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findAllByUserid(String userid);
}
