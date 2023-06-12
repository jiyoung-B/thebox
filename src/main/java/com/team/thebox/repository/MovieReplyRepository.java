package com.team.thebox.repository;

import com.team.thebox.model.MovieReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieReplyRepository extends JpaRepository<MovieReply, Long> {

    List<MovieReply> findByMovnoOrderByRegdateAsc(Long movno);

//    @Modifying
//    @Transactional
//    @Query("update MovieReply set reply = :reply, star = :star where rpno = :rpno")
//    int updateReply(@Param("reply")String reply, @Param("star")int star, @Param("rpno")Long rpno);
}
