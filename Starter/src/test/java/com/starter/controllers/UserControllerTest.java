package com.starter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;

public class UserControllerTest extends BaseControllerTest {

	@Mock
	private UserDAO			userDAO;

	@InjectMocks
	private UserController	userController;

	@Override
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("username");
		userEntity.setFirstName("firstname");
		userEntity.setLastName("lastname");
		Mockito.when(this.userDAO.getCurrentUser()).thenReturn(userEntity);
		Mockito.when(this.userDAO.selectById(Mockito.any(UUID.class))).thenReturn(userEntity);

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
	}

	@Test
	public void testUsers() throws Exception {
		this.mockMvc.perform(get("/users")).andExpect(status().isOk()).andExpect(view().name("users.list"));
	}

	@Test
	public void testUserDetails() throws Exception {
		this.mockMvc.perform(get("/users/1")).andExpect(status().isOk()).andExpect(view().name("users.details"));
	}

	@Test
	public void testUsersNew() throws Exception {
		this.mockMvc.perform(get("/users/new")).andExpect(status().isOk()).andExpect(view().name("users.new"));
	}

	@Test
	public void testUserCreate() throws Exception {
		MockHttpServletRequestBuilder post = post("/users");
		post.param("userName", "aNewUsername");
		post.param("firstName", "FirstName");
		post.param("lastName", "LastName");
		post.param("emailAddress", "email@starter.com");

		this.mockMvc.perform(post).andExpect(view().name("redirect:/users"));

		Mockito.verify(this.userDAO, Mockito.times(1)).create(Mockito.any(UserEntity.class));
	}

	@Test
	public void testUsersEdit() throws Exception {
		this.mockMvc.perform(get("/users/1/edit")).andExpect(status().isOk()).andExpect(view().name("users.edit"));
	}

	@Test
	public void testUserUpdate() throws Exception {
		MockHttpServletRequestBuilder put = put("/users/1");
		put.param("userName", "aNewUsername");
		put.param("firstName", "FirstName");
		put.param("lastName", "LastName");
		put.param("emailAddress", "email@starter.com");

		this.mockMvc.perform(put).andExpect(view().name("redirect:/users"));

		Mockito.verify(this.userDAO, Mockito.times(1)).update(Mockito.any(UserEntity.class), Mockito.any(UserForm.class));
	}

	@Test
	public void testUsersChangePassword() throws Exception {
		this.mockMvc.perform(get("/users/change-password")).andExpect(status().isOk()).andExpect(view().name("users.change-password"));
	}

}
