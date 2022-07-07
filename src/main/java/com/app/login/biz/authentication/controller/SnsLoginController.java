package com.app.login.biz.authentication.controller;

import com.app.login.sys.util.Result;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/snsLogin")
public class SnsLoginController {

    // Client ID
    private String CLIENT_ID = "04d29f14e1d142ce6b7ca0765071bd25";

    // Redirect URI
    private String REDIRECT_URI = "http://localhost:5000/kakaoLoginProc";

    // KAKAO Auth Url
    private String KAKAO_AUTH_URL = "https://kauth.kakao.com";


    @GetMapping("/getAuthPage")
    public ResponseEntity<String> kakaoLoginAuth() {
        String authPageUrl = KAKAO_AUTH_URL + "/oauth/authorize?"
                                            + "response_type=code&"
                                            + "client_id=" + CLIENT_ID + "&"
                                            + "redirect_uri=" + REDIRECT_URI;

        return ResponseEntity.ok().body(authPageUrl);
    }
}
