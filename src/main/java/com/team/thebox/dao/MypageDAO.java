package com.team.thebox.dao;

import com.team.thebox.model.Member;

import java.util.Map;

public interface MypageDAO {
    Member selectOneMember(String userid);

    Map<String, Object> selectBookingDetails(String userid);

    Map<String, Object> selectCancellationDetails(String userid);

    Map<String, Object> selectTop2(String userid);

    Map<String, Object> selectPoster(String title);

    void updateEmail(String userid, String fillEmail);

    void updatePhnum(String userid, String changePhnum);

    void updatePswd(String userid, String newPswd2);

    void deleteMember(String userid);
}
