package com.team.thebox.service;

import com.team.thebox.dao.MypageDAO;
import com.team.thebox.model.CancellationDetails;
import com.team.thebox.model.Member;
import com.team.thebox.utils.MypageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service("mpsrv")
public class MypageServiceImpl implements MypageService{

    @Autowired
    private MypageDAO mpdao;

    @Autowired
    private MypageUtils mypageUtils;

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
    public void rmBkNnewCan(int bkno, CancellationDetails cds) {
        mpdao.delBkNinsCan(bkno, cds);
    }

    @Override
    public void modifyProfile(String userid, MultipartFile attach) {

        // 첨부파일 업로드 처리
        mypageUtils.processUpload(userid, attach);

        // 첨부파일 정보 db에 저장
        mpdao.updateProfile(userid, attach);
    }
}
