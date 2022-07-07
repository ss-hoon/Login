package com.app.login.biz.authentication.service;

import com.app.login.biz.authentication.model.Member;
import com.app.login.biz.authentication.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = authenticationService.getMemberByID(username);

        if(ObjectUtils.isEmpty(member)) {
            throw new UsernameNotFoundException(username + " not exists.");
        }

        return new UserDetails(member);
    }
}
