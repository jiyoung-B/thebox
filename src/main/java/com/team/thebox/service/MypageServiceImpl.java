package com.team.thebox.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.thebox.dao.MypageDAO;
import com.team.thebox.model.BookingDetails;
import com.team.thebox.model.CancellationDetails;
import com.team.thebox.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Map<String, Object> readTop2(String userid) {
        return mpdao.selectTop2(userid);
    }

    @Override
    public void modifyEmail(String userid, String fillEmail) {
        mpdao.updateEmail(userid, fillEmail);
    }

    @Override
    public void modifyPhnum(String userid, String changePhnum) {
        mpdao.updatePhnum(userid, changePhnum);
    }

    @Override
    public void modifynewPswd(String userid, String newPswd2) {
        mpdao.updatePswd(userid, newPswd2);
    }

    @Override
    public void removeMember(String userid) {
        mpdao.deleteMember(userid);
    }

    @Override
    public Map<String, Object> readPoster(String userid) {

        return mpdao.selectPoster(userid);
    }

    @Override
    public void rmBkNnewCan(int bkno, CancellationDetails cds) {

        mpdao.delBkNinsCan(bkno, cds);
    }
}
