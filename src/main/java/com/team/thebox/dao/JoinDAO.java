package com.team.thebox.dao;

import com.team.thebox.model.Member;

public interface JoinDAO {

    int insertMember(Member m);

    int selectOneUserid(String uid);

}
