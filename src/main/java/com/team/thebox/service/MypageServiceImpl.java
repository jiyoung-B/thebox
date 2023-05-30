package com.team.thebox.service;

import com.team.thebox.dao.MypageDAO;
import com.team.thebox.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mpsrv")
public class MypageServiceImpl implements MypageService{

    @Autowired
    private MypageDAO mpdao;

    @Override
    public Member readOneMember(String userid) {
        return mpdao.selectOneMember(userid);
    }
}
