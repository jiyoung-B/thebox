package com.team.thebox.service;

import com.team.thebox.dao.MypageDAO;
import com.team.thebox.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("mpsrv")
public class MypageServiceImpl implements MypageService{

    @Autowired
    private MypageDAO mpdao;

    @Override
    public Member readOneMember(String userid) {
        return mpdao.selectOneMember(userid);
    }

    @Override
    public Map<String, Object> readBookingDetails(String userid) {

        return mpdao.selectBookingDetails(userid);
    }

    @Override
    public Map<String, Object> readCancellationDetails(String userid) {
        return mpdao.selectCancellationDetails(userid);
    }
}
