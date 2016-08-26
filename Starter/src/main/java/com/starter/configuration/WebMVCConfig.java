package com.starter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.starter.interceptors.StarterHandlerInterceptor;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

	@Bean
	public StarterHandlerInterceptor authInjectionInterceptor() {
		return new StarterHandlerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.authInjectionInterceptor()).addPathPatterns("/login/**");
	}

}
