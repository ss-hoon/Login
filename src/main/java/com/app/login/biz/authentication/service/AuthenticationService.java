package com.app.login.biz.authentication.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.login.biz.authentication.model.Member;
import com.app.login.sys.util.Result;

@Service
public class AuthenticationService {

	public ResponseEntity<Result> login(Member member) {
		if(!member.getUserId().equals("lee")) {
			Result result = new Result().loginFailInstance();
			
			result.setMessage("등록된 아이디가 없습니다.");
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
		}
		
		if(!member.getUserPwd().equals("123")) {
			Result result = new Result().loginFailInstance();
			
			result.setMessage("비밀번호가 다릅니다.");
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
		}
		
		return ResponseEntity.ok(new Result().loginSuccessInstance());
	}
}
