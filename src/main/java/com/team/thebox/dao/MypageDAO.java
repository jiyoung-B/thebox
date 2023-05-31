package com.team.thebox.dao;

import com.team.thebox.model.Member;

import java.util.Map;

public interface MypageDAO {
    Member selectOneMember(String userid);

    Map<String, Object> selectBookingDetails(String userid);

    Map<String, Object> selectCancellationDetails(String userid);
}
