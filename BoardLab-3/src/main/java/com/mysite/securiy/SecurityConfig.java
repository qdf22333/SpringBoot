package com.mysite.securiy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration	//Spring Boot의 각종 설정을 잡는 어노테이션, Security에 대한 설정
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests().requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
		
		.and()
			.csrf()
			.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
		.and()
			.headers()
			.addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
		.and()
			.formLogin()	//ID와 Password를 인증하는 폼
			.loginPage("/member/login")	//로그인 페이지를 정의
			.defaultSuccessUrl("/")
			/*
			.usernameParameter("email")	//view 페이지의 ID 변수의 name = "email"
			.passwordParameter("pw")	//view 페이지에서 Password 변수의 name = "pw"
			*/
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			;
	return http.build();
	}
	
	//최종적으로 인증을 처리하는 객체
	
	@Bean
	AuthenticationManager authenticateionManager(AuthenticationConfiguration authenticationConfiguration) 
	throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//Spring Security를 적용하려면 패스워드 필드는 반드시 암호화가 되어있어야 함.
	//패스워드 필드를 암호화 
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
