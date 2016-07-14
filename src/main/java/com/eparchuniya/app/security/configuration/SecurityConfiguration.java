package com.eparchuniya.app.security.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.eparchuniya.app.security.service.CustomeUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	CustomeUserDetailService customeUserDetailService;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		auth.userDetailsService(customeUserDetailService).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/", "/home").permitAll()
	  	.antMatchers("/adminmanagement/**").access("hasRole('ROLE_ADMIN')")
	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  	.usernameParameter("userId").passwordParameter("password")
	  	.and().csrf()
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
//		http
//	      .csrf().disable()
//	      .authorizeRequests()
//	        .antMatchers(HttpMethod.POST, "/checksecurity").access("hasRole('ROLE_ADMIN')")
//	        .antMatchers(HttpMethod.PUT, "/checksecurity").authenticated()
//	        .antMatchers(HttpMethod.DELETE, "/checksecurity").authenticated()
//	        .anyRequest().permitAll()
//	        .and()
//	      .httpBasic().and()
//	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
