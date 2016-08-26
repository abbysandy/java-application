package com.starter.providers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;

@Component
public class StarterAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDAO userDAO;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		Object credentials = authentication.getCredentials();

		UserEntity user = this.userDAO.login(name, credentials.toString());
		if (user == null) {
			return null;
		}

		Collection<? extends GrantedAuthority> authorities = this.userDAO.getAuthorities(user.getRoles());

		return new UsernamePasswordAuthenticationToken(name, credentials, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
