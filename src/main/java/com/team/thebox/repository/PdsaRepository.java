package com.team.thebox.repository;

import com.team.thebox.domain.Pds;
import com.team.thebox.domain.PdsAttach;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PdsaRepository
        extends JpaRepository<PdsAttach, Long> {

    PdsAttach findByPno(int pno);

    @Transactional
    @Modifying
    @Query("update PdsAttach set fdown = fdown + 1 where pno = :pno")
    void countDownByPno(@Param("pno") int pno);

    // 파일확장자만 따로 조회해서 리스트에 저장 - native query 사용
    @Query(value = "select ftype from pdsattach", nativeQuery=true)
    List<String> findByFtypes();

}