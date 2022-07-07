package com.app.login.biz.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.login.biz.authentication.mapper.AuthenticationMapper;
import com.app.login.biz.authentication.model.Member;
import com.app.login.sys.util.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
@Slf4j
public class AuthenticationService {
	
	@Autowired
	private AuthenticationMapper authenticationMapper;

	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 로그인
	 * @param member	사용자 정보
	 * @return	로그인 결과
	 */
	public Result login(Member member) {
		UsernamePasswordAuthenticationToken authenticationToken = member.toAuthentication();

		try {
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		} catch (AuthenticationException ae) {
			return Result.loginIdFailInstance();
		}

		return Result.loginSuccessInstance();
	}

	public Member getMemberByID(String id) {
		return Optional.ofNullable(authenticationMapper.getUserInfo(id))
				.orElse(null);
	}
}
