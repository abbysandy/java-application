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

import com.starter.dao.CategoryDAO;
import com.starter.entities.CategoryEntity;
import com.starter.forms.CategoryForm;

public class CategoryControllerTest extends BaseControllerTest {

	@Mock
	private CategoryDAO			categoryDAO;

	@InjectMocks
	private CategoryController	categoryController;

	private UUID				id;

	@Override
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		this.id = UUID.randomUUID();

		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(this.id);
		categoryEntity.setName("Name");
		Mockito.when(this.categoryDAO.selectById(Mockito.any(UUID.class))).thenReturn(categoryEntity);

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.categoryController).build();
	}

	@Test
	public void testCategories() throws Exception {
		this.mockMvc.perform(get("/categories")).andExpect(status().isOk()).andExpect(view().name("categories.list"));
	}

	@Test
	public void testCategoryDetails() throws Exception {
		this.mockMvc.perform(get(String.format("/categories/%s", this.id))).andExpect(status().isOk()).andExpect(view().name("categories.details"));
	}

	@Test
	public void testCategoryNew() throws Exception {
		this.mockMvc.perform(get("/categories/new")).andExpect(status().isOk()).andExpect(view().name("categories.new"));
	}

	@Test
	public void testCategoryCreate() throws Exception {
		MockHttpServletRequestBuilder post = post("/categories");
		post.param("name", "A New Name");

		this.mockMvc.perform(post).andExpect(view().name("redirect:/categories"));

		Mockito.verify(this.categoryDAO, Mockito.times(1)).create(Mockito.any(CategoryEntity.class));
	}

	@Test
	public void testCategoryEdit() throws Exception {
		this.mockMvc.perform(get(String.format("/categories/%s/edit", this.id))).andExpect(status().isOk()).andExpect(view().name("categories.edit"));
	}

	@Test
	public void testCategoryUpdate() throws Exception {
		MockHttpServletRequestBuilder put = put(String.format("/categories/%s", this.id));
		put.param("name", "A New Name");

		this.mockMvc.perform(put).andExpect(view().name("redirect:/categories"));

		Mockito.verify(this.categoryDAO, Mockito.times(1)).update(Mockito.any(CategoryEntity.class), Mockito.any(CategoryForm.class));
	}
}
