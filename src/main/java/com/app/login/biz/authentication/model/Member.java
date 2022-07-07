package com.app.login.biz.authentication.model;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class Member {
	
	private String userId;
	
	private String userPwd;
	
	private String userName;
	
	private int userAge;
	
	private String userEmail;

	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(this.userId, this.userPwd);
	}
}
