package com.starter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

public class ErrorControllerTest extends BaseControllerTest {

	@Test
	public void test400() throws Exception {
		this.mockMvc.perform(get("/errors/400")).andExpect(status().isBadRequest()).andExpect(view().name("errors.400"));
	}

	@Test
	public void test404() throws Exception {
		this.mockMvc.perform(get("/errors/404")).andExpect(status().isNotFound()).andExpect(view().name("errors.404"));
	}

	@Test
	public void test500() throws Exception {
		this.mockMvc.perform(get("/errors/500")).andExpect(status().isInternalServerError()).andExpect(view().name("errors.500"));
	}

}
