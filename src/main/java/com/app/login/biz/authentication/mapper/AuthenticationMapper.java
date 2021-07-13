package com.app.login.biz.authentication.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.app.login.biz.authentication.model.Member;

@Mapper
public interface AuthenticationMapper {
	Member getUserInfo(String userId);
}
