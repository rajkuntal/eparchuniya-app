package com.graminmart.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.graminmart.app.domain.admin.User;
import com.graminmart.app.domain.admin.UserRole;
import com.graminmart.app.service.AdminService;

@Component("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AdminService adminService;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		final User user;

		if ("ADMIN".equalsIgnoreCase(userName) && adminService.findUserByName(userName) == null) {
			user = adminService.createAdminUserInAppStart();
		} else {
			user = adminService.findUserByName(userName);
		}

		UserDetails userDetails = new UserDetails() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 8313756630332370891L;

			public boolean isEnabled() {
				return user.getIsActive();
			}

			public boolean isCredentialsNonExpired() {
				return true;
			}

			public boolean isAccountNonLocked() {
				return true;
			}

			public boolean isAccountNonExpired() {
				return true;
			}

			public String getUsername() {
				return user.getUserName();
			}

			public String getPassword() {
				return user.getPassword();
			}

			public Collection<? extends GrantedAuthority> getAuthorities() {
				return getUserAuthorities(user);
			}
		};

		return userDetails;
	}

	public Collection<? extends GrantedAuthority> getUserAuthorities(User user) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

		Set<UserRole> roles = user.getUserRoles();

		if ("ADMIN".equalsIgnoreCase(user.getUserName())) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		} else {

			Iterator<UserRole> iterator = roles.iterator();

			while (iterator.hasNext()) {
				UserRole userRole = (UserRole) iterator.next();
				authList.add(new SimpleGrantedAuthority(userRole.getName()));
			}
		}
		return authList;
	}

}
