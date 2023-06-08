package com.team.thebox.service;

import com.team.thebox.model.Member;



public interface JoinService {

    boolean newMember(Member m);

    int checkUserid(String uid);
}
