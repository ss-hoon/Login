package com.app.login.sys.util;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

	static final String LOGIN_SUCCESS = "로그인 성공";
	
	HttpStatus statusCode;
	String message;
	Object data;
	Object error;
	
	public Result instance() {
		return new Result();
	}
	
	// 로그인 성공 Result
	public Result loginSuccessInstance() {
		Result result = new Result();
		
		result.setStatusCode(HttpStatus.OK);
		result.setMessage(LOGIN_SUCCESS);
		
		return result;
	}
	
	// 로그인 실패 Result
	public Result loginFailInstance() {
		Result result = new Result();
		
		result.setStatusCode(HttpStatus.FORBIDDEN);
		
		return result;
	}
}
