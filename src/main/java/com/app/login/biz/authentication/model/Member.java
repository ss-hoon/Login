package com.app.login.biz.authentication.model;

import lombok.Data;

@Data
public class Member {
	
	private String userId;
	
	private String userPwd;
	
	private String userName;
	
	private int userAge;
	
	private String userEmail;
}
