package com.starter.configuration;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

public class ErrorConfiguration implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/errors/400"));
		registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/errors/404"));
		registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errors/500"));
	}

}
