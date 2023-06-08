package com.team.thebox.repository;

import com.team.thebox.model.Ticketing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketingRepository extends JpaRepository<Ticketing, Long> {
}
