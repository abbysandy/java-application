package com.starter.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.starter.providers.StarterAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource						dataSource;

	@Autowired
	private PasswordEncoder					passwordEncoder;

	@Autowired
	private StarterAuthenticationProvider	starterAuthenticationProvider;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> jdbcAuthenticatedDataSource = auth.jdbcAuthentication().dataSource(this.dataSource).passwordEncoder(this.passwordEncoder);
		jdbcAuthenticatedDataSource.usersByUsernameQuery("SELECT user_name, password, enabled FROM users WHERE user_name = ?");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/login/**", "/webjars/**", "/assets/**").permitAll().anyRequest().authenticated();
		httpSecurity.formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("userName").passwordParameter("password");
		httpSecurity.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.starterAuthenticationProvider);
	}

}
