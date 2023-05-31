package com.team.thebox.repository;

import com.team.thebox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MypageRepository extends JpaRepository<Member, Long> {
    Member findAllByUserid(String userid);

    @Modifying
    @Transactional
    @Query("update Member set email = :email where userid = :userid")
    String updateByEmail(String userid);
}
