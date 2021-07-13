package com.app.login.biz.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.login.biz.authentication.mapper.AuthenticationMapper;
import com.app.login.biz.authentication.model.Member;
import com.app.login.sys.util.Result;

@Service
public class AuthenticationService {
	
	@Autowired
	private AuthenticationMapper authenticationMapper;

	public ResponseEntity<Result> login(Member member) {
		
		Member memberInfo = authenticationMapper.getUserInfo(member.getUserId());
		
		if(memberInfo == null) {
			Result result = new Result().loginFailInstance();
			
			result.setMessage("등록된 아이디가 없습니다.");
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
		}
		
		if(!memberInfo.getUserPwd().equals(member.getUserPwd())) {
			Result result = new Result().loginFailInstance();
			
			result.setMessage("비밀번호가 다릅니다.");
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
		}
		
		return ResponseEntity.ok(new Result().loginSuccessInstance());
	}
}
