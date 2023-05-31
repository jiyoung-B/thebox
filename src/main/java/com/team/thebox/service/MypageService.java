package com.team.thebox.service;

import com.team.thebox.model.Member;

import java.util.Map;

public interface MypageService {
    Member readOneMember(String userid);

    Map<String, Object> readBookingDetails(String userid);

    Map<String, Object> readCancellationDetails(String userid);
}
