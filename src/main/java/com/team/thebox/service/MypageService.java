package com.team.thebox.service;

import com.team.thebox.model.Member;

import java.util.Map;

public interface MypageService {
    Member readOneMember(String userid);

    Map<String, Object> readBookingDetails(String userid);

    Map<String, Object> readCancellationDetails(String userid);

    Map<String, Object> readTop2(String userid);

    byte[] readPoster(String title);

    void modifyEmail(String userid, String newEmail);

    void modifyPhnum(String userid, String newPhnum);

    void modifynewPswd(String userid, String newPswd);
}
