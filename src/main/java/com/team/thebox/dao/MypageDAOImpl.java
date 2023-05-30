package com.team.thebox.dao;

import com.team.thebox.model.Member;
import com.team.thebox.repository.MypageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mpdao")
public class MypageDAOImpl implements MypageDAO{

    @Autowired
    MypageRepository mypageRepository;

    @Override
    public Member selectOneMember(String userid) {
//        mypageRepository.updateByEmail(userid);
        return mypageRepository.findAllByUserid(userid);
    }
}
