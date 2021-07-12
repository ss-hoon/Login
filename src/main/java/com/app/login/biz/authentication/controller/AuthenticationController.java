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

	@PostMapping("/login")
	public ResponseEntity<Result> login(@RequestBody Member member) {
		log.info("member : {}", member);
		
		return authenticationService.login(member);
	}
}
