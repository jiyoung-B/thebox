package com.team.thebox.service;

import com.team.thebox.model.CancellationDetails;
import com.team.thebox.model.Member;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface MypageService {
    Member readOneMember(String userid);

    Map<String, Object> readBookingDetails(String userid);

    Map<String, Object> readCancellationDetails(String userid);

    Map<String, Object> readTop2(String userid);

    void modifyEmail(String userid, String fillEmail);

    void modifyPhnum(String userid, String changePhnum);

    void modifynewPswd(String userid, String newPswd2);

    void removeMember(String userid);

    void rmBkNnewCan(int bkno, CancellationDetails cds);

    void modifyProfile(String userid, MultipartFile attach);
}
