package com.team.thebox.repository;

import com.team.thebox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MypageRepository extends JpaRepository<Member, Long> {
    Member findAllByUserid(String userid);
}
