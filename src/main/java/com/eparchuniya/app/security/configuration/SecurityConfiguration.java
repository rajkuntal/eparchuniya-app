package com.eparchuniya.app.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//	  http.authorizeRequests()
//	  	.antMatchers("/", "/home").access("hasRole('USER')")
//	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
//	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
//	  	.usernameParameter("ssoId").passwordParameter("password")
//	  	.and().csrf()
//	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
		http
	      .csrf().disable()
	      .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/checksecurity").authenticated()
	        .antMatchers(HttpMethod.PUT, "/checksecurity").authenticated()
	        .antMatchers(HttpMethod.DELETE, "/checksecurity").authenticated()
	        .anyRequest().permitAll()
	        .and()
	      .httpBasic().and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
