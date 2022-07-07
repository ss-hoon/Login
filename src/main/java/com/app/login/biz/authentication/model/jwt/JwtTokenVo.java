package com.app.login.biz.authentication.model.jwt;

import java.util.Date;

public class JwtTokenVo {

    /** Access Token */
    private final String accessToken;

    /** Refresh Token */
    private final String refreshToken;

    /** Access Token 만료 시간 */
    private final Date accessTokenExpiredTime;

    /** Access Token 만료 시간 */
    private final Date refreshTokenExpiredTime;

    /**
     * JwtTokenVo 생성자
     * @param accessToken               Access Token
     * @param refreshToken              Refresh Token
     * @param accessTokenExpiredTime    Access Token 만료 시간
     * @param refreshTokenExpiredTime   Refresh Token 만료 시간
     */
    public JwtTokenVo(String accessToken, String refreshToken, Date accessTokenExpiredTime, Date refreshTokenExpiredTime) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpiredTime = accessTokenExpiredTime;
        this.refreshTokenExpiredTime = refreshTokenExpiredTime;
    }
}
