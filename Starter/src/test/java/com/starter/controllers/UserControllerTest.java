package com.starter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;

public class UserControllerTest extends BaseControllerTest {

	@Mock
	private UserDAO	userDAO;

	@InjectMocks
	UserController	userController;

	@Override
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		UserEntity userEntity = new UserEntity();
		Mockito.when(this.userDAO.getCurrentUser()).thenReturn(userEntity);

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
	}

	@Test
	public void testUsers() throws Exception {
		this.mockMvc.perform(get("/users")).andExpect(status().isOk()).andExpect(view().name("users.list"));
	}

	@Test
	public void testUsersNew() throws Exception {
		this.mockMvc.perform(get("/users/new")).andExpect(status().isOk()).andExpect(view().name("users.new"));
	}

	@Test
	public void testUsersChangePassword() throws Exception {
		this.mockMvc.perform(get("/users/change-password")).andExpect(status().isOk()).andExpect(view().name("users.change-password"));
	}

}
