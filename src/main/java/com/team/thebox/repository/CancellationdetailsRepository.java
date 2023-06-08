package com.team.thebox.repository;

import com.team.thebox.model.CancellationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancellationdetailsRepository extends JpaRepository<CancellationDetails, Long> {
    List<CancellationDetails> findAllByUseridOrderByCancellationdate(String userid);
}
