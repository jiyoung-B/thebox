package com.team.thebox.repository;

import com.team.thebox.model.Pds;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PdsRepository
        extends JpaRepository<Pds, Long> {

    @Modifying
    @Transactional
    @Query("update Pds set views = views + 1 where pno = :pno")
    void countViewById(@Param("pno") long pno);

}