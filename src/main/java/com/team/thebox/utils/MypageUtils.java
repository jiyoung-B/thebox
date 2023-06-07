package com.team.thebox.utils;

import com.team.thebox.dao.MypageDAO;
import com.team.thebox.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component("mypageUtils")
public class MypageUtils {

    // 프로필 사진 저장 위치
    @Value("${profileDir}")
    private String profileDir;

    @Autowired
    MypageDAO mypageDAO;

    public void processUpload(String userid, MultipartFile attach) {

        // 업로드할 파일 정보 취득
        Member mb = mypageDAO.selectOneMember(userid);

        // 첨부파일을 파일시스템에 저장
        // 시스템에 저장 시 사용할 파일명 : userid.확장자
        String orgFname = attach.getOriginalFilename();
        int pos = orgFname.lastIndexOf(".") + 1;
        String ext = orgFname.substring(pos);
        String saveProfilepic = profileDir + mb.getUserid() + "." + ext;

        // db에 저장
        /*String savePName = "http://localhost/profilepic/" + mb.getUserid();
        mb.setProfilepic(savePName);

        String orgFname = attach.getOriginalFilename();
        int pos = orgFname.lastIndexOf(".") + 1;
        String savePType = orgFname.substring(pos);
        mb.setPictype(savePType);*/

        try {
            attach.transferTo(new File(saveProfilepic));
        } catch (Exception ex) {
            System.out.println("업로드 중 오류 발생");
            ex.printStackTrace();
        }
    }
}
