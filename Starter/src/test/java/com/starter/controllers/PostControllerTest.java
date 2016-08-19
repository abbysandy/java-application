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
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.starter.dao.CategoryDAO;
import com.starter.dao.PostDAO;
import com.starter.dao.TagDAO;
import com.starter.dao.UserDAO;
import com.starter.entities.PostEntity;
import com.starter.forms.PostForm;

public class PostControllerTest extends BaseControllerTest {

	@Mock
	private PostDAO			postDAO;

	@Mock
	private UserDAO			userDAO;

	@Mock
	private CategoryDAO		categoryDAO;

	@Mock
	private TagDAO			tagDAO;

	@InjectMocks
	private PostController	postController;

	private UUID			id;

	@Override
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		this.id = UUID.randomUUID();

		PostEntity postEntity = new PostEntity();
		postEntity.setId(this.id);
		postEntity.setTitle("Title");
		Mockito.when(this.postDAO.selectById(Mockito.any(UUID.class))).thenReturn(postEntity);

		Mockito.when(this.userDAO.select(Mockito.any(Sort.class))).thenReturn(null);
		Mockito.when(this.categoryDAO.select(Mockito.any(Sort.class))).thenReturn(null);
		Mockito.when(this.tagDAO.select(Mockito.any(Sort.class))).thenReturn(null);

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.postController).build();
	}

	@Test
	public void testPosts() throws Exception {
		this.mockMvc.perform(get("/posts")).andExpect(status().isOk()).andExpect(view().name("posts.list"));
	}

	@Test
	public void testPostDetails() throws Exception {
		this.mockMvc.perform(get(String.format("/posts/%s", this.id))).andExpect(status().isOk()).andExpect(view().name("posts.details"));
	}

	@Test
	public void testPostNew() throws Exception {
		this.mockMvc.perform(get("/posts/new")).andExpect(status().isOk()).andExpect(view().name("posts.new"));
	}

	@Test
	public void testPostCreate() throws Exception {
		MockHttpServletRequestBuilder post = post("/posts");
		post.param("title", "A New Title");

		this.mockMvc.perform(post).andExpect(view().name("redirect:/posts"));

		Mockito.verify(this.postDAO, Mockito.times(1)).create(Mockito.any(PostEntity.class));
	}

	@Test
	public void testPostEdit() throws Exception {
		this.mockMvc.perform(get(String.format("/posts/%s/edit", this.id))).andExpect(status().isOk()).andExpect(view().name("posts.edit"));
	}

	@Test
	public void testPostUpdate() throws Exception {
		MockHttpServletRequestBuilder put = put(String.format("/posts/%s", this.id));
		put.param("title", "A New Title");

		this.mockMvc.perform(put).andExpect(view().name("redirect:/posts"));

		Mockito.verify(this.postDAO, Mockito.times(1)).update(Mockito.any(PostEntity.class), Mockito.any(PostForm.class));
	}

}
