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

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<Result> login(@RequestBody Member member) {		
		return authenticationService.login(member);
	}
}
