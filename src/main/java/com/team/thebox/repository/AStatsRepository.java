package com.team.thebox.repository;

import com.team.thebox.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AStatsRepository extends JpaRepository<Stats, Long> {
    List<Stats> findFirst5ByOrderByBoxofficeDesc();
    List<Stats> findFirst5ByOrderByCumulativeboxofficeDesc();
    List<Stats> findFirst5ByOrderBySalesDesc();
    List<Stats> findFirst5ByOrderBySalesshareDesc();
}
