package com.team.thebox.service;

import com.team.thebox.model.KakaoApproveResponse;
import com.team.thebox.model.KakaoReadyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service("kkpsrv")
//@RequiredArgsConstructor
//@Transactional
public class KakaoPayServiceImpl implements KakaoPayService{

    static final String cid = "TC0ONETIME"; // 가맹점 테스트 코드
//    static final String admin_Key = "${ADMIN_KEY}"; // 공개 조심! 본인 애플리케이션의 어드민 키를 넣어주세요
    static final String admin_Key = "${8ef7050082cdb63e26caef35b876ae80}"; // 공개 조심! 본인 애플리케이션의 어드민 키를 넣어주세요
    private KakaoReadyResponse kakaoReady;

    @Override
    public KakaoReadyResponse kakaoPayReady() {
        // 카카오페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("item_name", "영화");
        parameters.add("quantity", "1");
        parameters.add("total_amount", "16500");
        parameters.add("vat_amount", "1500");
        parameters.add("tax_free_amount", "15000");
        parameters.add("approval_url", "http://localhost:8080/booking/success"); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:8080/booking/cancel"); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:8080/booking/fail"); // 실패 시 redirect url

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        kakaoReady = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready", requestEntity, KakaoReadyResponse.class);

        return kakaoReady;
    }

    // 결제 완료 승인
    public KakaoApproveResponse ApproveResponse(String pgToken) {

        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoApproveResponse approveResponse = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve", requestEntity, KakaoApproveResponse.class);

        return approveResponse;
    }

    // 카카오 요구 헤더값
    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_Key;

        httpHeaders.set("Authorization", auth);
        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }
}
