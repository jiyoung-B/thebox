package com.team.thebox.dao;

import com.team.thebox.model.Member;
import com.team.thebox.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jndao")
public class JoinDAOImpl implements JoinDAO {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public int insertMember(Member m) {
        int isSaved = -1;

        m = memberRepository.save(m);
        if (m != null) isSaved = Math.toIntExact(m.getPmno());

        return isSaved;
    }

    @Override
    public int selectOneUserid(String uid) {
        return 0;
    }



}
