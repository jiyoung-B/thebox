package com.team.thebox.repository;

import com.team.thebox.model.MovieReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieReplyRepository extends JpaRepository<MovieReply, Long> {

    List<MovieReply> findByMovnoOrderByRegdateAsc(int movno);
}
