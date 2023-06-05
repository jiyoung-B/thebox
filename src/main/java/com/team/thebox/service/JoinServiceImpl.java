package com.team.thebox.service;

import com.team.thebox.dao.JoinDAO;
import com.team.thebox.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jnsrv")
public class JoinServiceImpl implements JoinService{
    @Autowired private JoinDAO jndao;

    @Override
    public boolean newMember(Member m) {
        boolean result = false;

        if (jndao.insertMember(m) > 0) result = true;

        return result;
    }

    @Override
    public int checkUserid(String uid) {
        return jndao.selectOneUserid(uid);
    }
}
