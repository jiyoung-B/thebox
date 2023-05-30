package com.team.thebox.repository;

import com.team.thebox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    int countByUseridAndPasswd(String userid, String passwd);
}
