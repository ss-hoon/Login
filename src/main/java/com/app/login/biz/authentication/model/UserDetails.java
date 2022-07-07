package com.app.login.biz.authentication.model;

import com.app.login.biz.authentication.model.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private String userId;

    private String userPwd;

    private String userName;

    private int userAge;

    private String userEmail;

    public UserDetails(Member member) {
        this.userId = member.getUserId();
        this.userPwd = member.getUserPwd();
        this.userName = member.getUserName();
        this.userAge = member.getUserAge();
        this.userEmail = member.getUserEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(new String[]{"ROLE_USER"})
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.userPwd;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
