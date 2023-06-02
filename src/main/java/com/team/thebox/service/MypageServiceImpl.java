package com.team.thebox.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.thebox.dao.MypageDAO;
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
    public byte[] readPoster(String title) {

        ObjectMapper mapper = new ObjectMapper();
        byte[] json = "".getBytes();

        try {
            json = mapper.writeValueAsBytes(
                    mpdao.selectPoster(title));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        return json;
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
}
