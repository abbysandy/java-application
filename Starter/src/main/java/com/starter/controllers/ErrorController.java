package com.starter.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorController {

	@RequestMapping("/errors/400")
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String badRequest() {
		return "errors.400";
	}

	@RequestMapping("/errors/403")
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public String forbidden() {
		return "errors.403";
	}

	@RequestMapping("/errors/404")
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String notFound() {
		return "errors.404";
	}

	@RequestMapping("/errors/500")
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String internalServerError() {
		return "errors.500";
	}

}
