package com.starter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.starter.interceptors.HomeRedirectInterceptor;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

	@Bean
	public HomeRedirectInterceptor authInjectionInterceptor() {
		return new HomeRedirectInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.authInjectionInterceptor()).addPathPatterns("/login/**");
	}

}
