package com.team.thebox.service;

import com.team.thebox.model.KakaoApproveResponse;
import com.team.thebox.model.KakaoReadyResponse;

public interface KakaoPayService {
    KakaoReadyResponse kakaoPayReady();
    KakaoApproveResponse ApproveResponse(String pgToken);
}
