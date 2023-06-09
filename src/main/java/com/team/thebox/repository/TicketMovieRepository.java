package com.team.thebox.repository;

import com.team.thebox.model.TicketMovie;
import com.team.thebox.model.TicketMovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketMovieRepository extends JpaRepository<TicketMovie, Long> {

}
