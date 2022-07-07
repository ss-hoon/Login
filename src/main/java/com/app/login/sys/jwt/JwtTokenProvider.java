package com.app.login.sys.jwt;

import com.app.login.biz.authentication.model.jwt.JwtTokenVo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtTokenProvider {

    /** HMAC-SHA 알고리즘으로 인코딩 된 Secret Key 객체 */
    private final Key encSeretKey;

    /** Access Token 만료시간 */
    private final long accessTokenExpiredTime;

    /** Refresh Token 만료시간 */
    private final long refreshTokenExpiredTime;

    /**
     * JwtTokenProvider 생성자
     * @param secretKey                 비밀키
     * @param accessTokenExpiredTime    AccessToken 만료시간
     * @param refreshTokenExpiredTime   RefreshToken 만료시간
     */
    public JwtTokenProvider(String secretKey, int accessTokenExpiredTime, int refreshTokenExpiredTime) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        encSeretKey = Keys.hmacShaKeyFor(keyBytes);

        this.accessTokenExpiredTime = accessTokenExpiredTime * 1000L;
        this.refreshTokenExpiredTime = refreshTokenExpiredTime * 1000L;
    }

    public JwtTokenVo generateTokenVo(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = new Date().getTime();

        Date accessTokenExpiresIn = new Date(now + accessTokenExpiredTime);
        Date refreshTokenExpiresIn = new Date(now + refreshTokenExpiredTime);

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String subject = principal.getUsername();

        // Create Access Token
        String accessToken = Jwts.builder()
                .signWith(encSeretKey, SignatureAlgorithm.HS512)
                .setSubject(subject)
                .claim("authorities", authorities)
                .setExpiration(accessTokenExpiresIn)
                .compact();

        // Create Refresh Token
        String refreshToken = Jwts.builder()
                .signWith(encSeretKey, SignatureAlgorithm.HS512)
                .setSubject(subject)
                .setExpiration(accessTokenExpiresIn)
                .compact();

        return new JwtTokenVo(accessToken, refreshToken, accessTokenExpiresIn, refreshTokenExpiresIn);
    }
}
