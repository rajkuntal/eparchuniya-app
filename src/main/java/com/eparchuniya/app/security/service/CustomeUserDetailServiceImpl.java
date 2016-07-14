package com.eparchuniya.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.User;
import com.eparchuniya.app.domain.UserRole;
import com.eparchuniya.app.service.AdminService;

@Component("customeUserDetailService")
public class CustomeUserDetailServiceImpl implements CustomeUserDetailService {

	@Autowired
	private AdminService adminService;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		final User user = adminService.findUserByName(userName);
        
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
				return getUserAuthorities(user.getUserRoles());
			}
		};
		
		return userDetails;
    }

	public Collection<? extends GrantedAuthority> getUserAuthorities(Set<UserRole> roles) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		
		Iterator<UserRole> iterator = roles.iterator();
		
		while(iterator.hasNext()) {
			UserRole userRole = (UserRole) iterator.next();	
			authList.add(new SimpleGrantedAuthority(userRole.getName()));
		}
		return authList;
	}

}
