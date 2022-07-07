package com.app.login.biz.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.login.biz.authentication.model.Member;
import com.app.login.biz.authentication.service.AuthenticationService;
import com.app.login.sys.util.Result;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/authentication")
@Slf4j
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * 로그인
	 * @param member	사용자 정보
	 * @return 로그인 결과
	 */
	@PostMapping("/login")
	public ResponseEntity<Result> login(@RequestBody Member member) {
		return ResponseEntity.ok().body(authenticationService.login(member));
	}
}
