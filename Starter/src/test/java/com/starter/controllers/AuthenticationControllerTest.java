package com.starter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

public class AuthenticationControllerTest extends BaseControllerTest {

	@Test
	public void testLogin() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("authentication.login"));
	}

	@Test
	public void testRegistration() throws Exception {
		this.mockMvc.perform(get("/registration")).andExpect(status().isOk()).andExpect(view().name("authentication.registration"));
	}

}
