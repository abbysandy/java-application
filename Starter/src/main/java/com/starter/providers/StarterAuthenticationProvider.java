package com.starter.providers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;

@Component
public class StarterAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDAO			userDAO;

	@Autowired
	private PasswordEncoder	passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();

		UserEntity user = this.userDAO.selectByUserName(userName);
		if (user == null) {
			return null;
		}

		boolean match = this.passwordEncoder.matches(password, user.getPassword());
		if (!match) {
			return null;
		}

		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new UsernamePasswordAuthenticationToken(userName, authentication.getCredentials(), grantedAuths);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
