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

import com.starter.dao.TagDAO;
import com.starter.entities.TagEntity;
import com.starter.forms.TagForm;

public class TagControllerTest extends BaseControllerTest {

	@Mock
	private TagDAO			tagDAO;

	@InjectMocks
	private TagController	tagController;

	private UUID			id;

	@Override
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		this.id = UUID.randomUUID();

		TagEntity TagEntity = new TagEntity();
		TagEntity.setId(this.id);
		TagEntity.setName("Name");
		Mockito.when(this.tagDAO.selectById(Mockito.any(UUID.class))).thenReturn(TagEntity);

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.tagController).build();
	}

	@Test
	public void testTags() throws Exception {
		this.mockMvc.perform(get("/tags")).andExpect(status().isOk()).andExpect(view().name("tags.list"));
	}

	@Test
	public void testTagDetails() throws Exception {
		this.mockMvc.perform(get(String.format("/tags/%s", this.id))).andExpect(status().isOk()).andExpect(view().name("tags.details"));
	}

	@Test
	public void testTagNew() throws Exception {
		this.mockMvc.perform(get("/tags/new")).andExpect(status().isOk()).andExpect(view().name("tags.new"));
	}

	@Test
	public void testTagCreate() throws Exception {
		MockHttpServletRequestBuilder post = post("/tags");
		post.param("name", "A New Name");

		this.mockMvc.perform(post).andExpect(view().name("redirect:/tags"));

		Mockito.verify(this.tagDAO, Mockito.times(1)).create(Mockito.any(TagEntity.class));
	}

	@Test
	public void testTagEdit() throws Exception {
		this.mockMvc.perform(get(String.format("/tags/%s/edit", this.id))).andExpect(status().isOk()).andExpect(view().name("tags.edit"));
	}

	@Test
	public void testTagUpdate() throws Exception {
		MockHttpServletRequestBuilder put = put(String.format("/tags/%s", this.id));
		put.param("name", "A New Name");

		this.mockMvc.perform(put).andExpect(view().name("redirect:/tags"));

		Mockito.verify(this.tagDAO, Mockito.times(1)).update(Mockito.any(TagEntity.class), Mockito.any(TagForm.class));
	}
}
