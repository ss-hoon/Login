package com.app.login.biz.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.login.biz.authentication.mapper.AuthenticationMapper;
import com.app.login.biz.authentication.model.Member;
import com.app.login.sys.util.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class AuthenticationService {
	
	@Autowired
	private AuthenticationMapper authenticationMapper;

	/**
	 * 로그인
	 * @param member	사용자 정보
	 * @return	로그인 결과
	 */
	public ResponseEntity<Result> login(Member member) {
		Member memberInfo = authenticationMapper.getUserInfo(member.getUserId());

		// 사용자 ID가 없는 경우
		if(ObjectUtils.isEmpty(memberInfo)) {
			Result result = Result.loginIdFailInstance();

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
		}

		// 비밀번호가 다른 경우
		if(!memberInfo.getUserPwd().equals(member.getUserPwd())) {
			Result result = Result.loginPwdFailInstance();

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
		}

		return ResponseEntity.ok(Result.loginSuccessInstance());
	}
}
