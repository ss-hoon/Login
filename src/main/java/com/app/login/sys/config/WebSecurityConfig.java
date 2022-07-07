package com.app.login.sys.config;

import com.app.login.biz.authentication.service.UserDetailsService;
import com.app.login.sys.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${jwt.secretkey}")
	private String jwtSecretKey;

	@Value("${jwt.expires.accessToken}")
	private int accessTokenExpiredTime;

	@Value("${jwt.expires.refreshToken}")
	private int refreshTokenExpiredTime;
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors()
				.and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/api/authentication/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin().disable();
	}

	@Bean
	public JwtTokenProvider jwtTokenProvider() {
		return new JwtTokenProvider(this.jwtSecretKey, this.accessTokenExpiredTime, this.refreshTokenExpiredTime);
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());

		return daoAuthenticationProvider;
	}
}