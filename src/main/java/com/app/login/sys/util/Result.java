package com.app.login.sys.util;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Result {

	static final int LOGIN_SUCCESS = 10;
	static final int LOGIN_ID_FAIL = 31;
	static final int LOGIN_PWD_FAIL = 32;
	
	String message;
	int resultCode;
	Object data;
	Object error;
	
	protected Result() {
		
	}
	
	// 로그인 성공 Result
	public static Result loginSuccessInstance() {
		Result result = new Result();
		result.resultCode = LOGIN_SUCCESS;
		
		return result;
	}
	
	// 아이디 매칭 실패 Result
	public static Result loginIdFailInstance() {
		Result result = new Result();
		result.resultCode = LOGIN_ID_FAIL;
		
		return result;
	}
	
	// 비밀번호 매칭 실패 Result
	public static Result loginPwdFailInstance() {
		Result result = new Result();
		result.resultCode = LOGIN_PWD_FAIL;
		
		return result;
	}
}
