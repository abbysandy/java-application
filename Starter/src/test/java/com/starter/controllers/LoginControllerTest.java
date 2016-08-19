package com.starter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

public class LoginControllerTest extends BaseControllerTest {

	@Test
	public void testLogin() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(view().name("login.login"));
	}

	@Test
	public void testRegistration() throws Exception {
		this.mockMvc.perform(get("/login/registration")).andExpect(status().isOk()).andExpect(view().name("login.registration"));
	}

	@Test
	public void testForgotPassword() throws Exception {
		this.mockMvc.perform(get("/login/forgot-password")).andExpect(status().isOk()).andExpect(view().name("login.forgot-password"));
	}

	@Test
	public void testForgotPasswordSent() throws Exception {
		this.mockMvc.perform(get("/login/forgot-password/sent")).andExpect(status().isOk()).andExpect(view().name("login.login.forgot-password-sent"));
	}

	@Test
	public void testChangePasswordInvalid() throws Exception {
		this.mockMvc.perform(get("/login/change-password/invalid")).andExpect(status().isOk()).andExpect(view().name("login.change-password-invalid"));
	}

	@Test
	public void testChangePassword() throws Exception {
		this.mockMvc.perform(get("/login/change-password/asdfqewrzxcv")).andExpect(status().isOk()).andExpect(view().name("login.change-password"));
	}

}
