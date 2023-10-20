package com.test.secu.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import com.test.secu.user.service.UserInfoService;

@Configuration
public class SecurityBeanConfig {
	@Autowired
	private UserInfoService userService;
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web->{
			web.ignoring()
			.antMatchers("/css/**","/js/**","/imgs/**","/resources/**","/tui/**");
		};
	}
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception{
		hs.authorizeRequests(req->req
				.antMatchers("/login","/join","/html/join","/html/login","/","/html/calendar")
				.permitAll()
				.antMatchers("/html/admin/**").hasRole("ADMIN")
				.antMatchers("/html/user/**").hasRole("USER")
				.anyRequest().authenticated())
		.formLogin(formLogin->formLogin
				.loginPage("/html/login")
				.usernameParameter("uiId")
				.passwordParameter("uiPwd")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/") //로그인 성공 시 인덱스 화면으로
				.failureUrl("/html/login-fail"))
		.logout(logout->logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/html/login"))	//로그아웃 성공 시 로그인 화면으로 
		.csrf(csrf->csrf.disable())
		.exceptionHandling(handling->handling.accessDeniedPage("/html/denied"))
		.userDetailsService(userService);
		
		return hs.build();
	}
}
