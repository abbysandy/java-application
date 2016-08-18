package com.starter.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starter.dao.PostDAO;
import com.starter.entities.PostEntity;
import com.starter.forms.PostForm;

@Controller
public class PostController extends BaseController {

	@Autowired
	private PostDAO postDAO;

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		List<PostEntity> posts = this.postDAO.select();
		model.addAttribute("posts", posts);
		return "posts.list";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String details(@PathVariable UUID id, Model model) {
		PostEntity post = this.postDAO.selectById(id);

		if (post == null) {
			return "redirect:/404";
		}

		model.addAttribute("post", post);
		return "posts.details";
	}

	@RequestMapping(value = "/posts/new", method = RequestMethod.GET)
	public String newPost(Model model) {
		model.addAttribute("postForm", new PostForm());
		return "posts.new";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String createPost(HttpServletResponse response, Model model, @Valid PostForm postForm, BindingResult binding, RedirectAttributes attr) {

		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("org.springframework.validation.BindingResult.postForm", binding);
			model.addAttribute("post", postForm);
			return "posts.new";
		}

		this.postDAO.create(postForm);

		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable UUID id, HttpServletResponse response, Model model) {
		PostEntity post = this.postDAO.selectById(id);

		if (post == null) {
			return "redirect:/404";
		}

		model.addAttribute("post", post);

		if (model.containsAttribute("postForm")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			PostForm postForm = (PostForm) this.postDAO.edit(post, PostForm.class);
			model.addAttribute("postForm", postForm);
		}

		return "posts.edit";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable UUID id, Model model, @Valid PostForm postForm, BindingResult binding, RedirectAttributes attr) {
		PostEntity post = this.postDAO.selectById(id);

		if (post == null) {
			return "redirect:/404";
		}

		if (binding.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.postForm", binding);
			attr.addFlashAttribute("postForm", postForm);
			return String.format("redirect:/posts/%s/edit", id);
		}

		this.postDAO.update(post, postForm);

		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable UUID id) {
		PostEntity post = this.postDAO.selectById(id);
		if (post != null) {
			this.postDAO.delete(post);
		}
		return "redirect:/posts";
	}

}

// CategoryEntity category = new CategoryEntity();
//
// category.setId(UUID.randomUUID());
// category.setName(UUID.randomUUID().toString());
// category.setCreatedAt(new Date());
// category.setUpdatedAt(new Date());
// category.setCreatedBy(this.userDAO.getCurrentUser());
// category.setUpdatedBy(this.userDAO.getCurrentUser());
//
// this.categoryRepository.save(category);
//
// // -----------------------------
//
// TagEntity tag = new TagEntity();
//
// tag.setId(UUID.randomUUID());
// tag.setName(UUID.randomUUID().toString());
// tag.setCreatedAt(new Date());
// tag.setUpdatedAt(new Date());
// tag.setCreatedBy(this.userDAO.getCurrentUser());
// tag.setUpdatedBy(this.userDAO.getCurrentUser());
//
// this.tagRepository.save(tag);
//
// // -----------------------------
//
// PostEntity post = new PostEntity();
//
// post.setId(UUID.randomUUID());
// post.setTitle(UUID.randomUUID().toString());
// post.setAlias(UUID.randomUUID().toString());
// post.setContent(UUID.randomUUID().toString());
//
// post.setCreatedAt(new Date());
// post.setUpdatedAt(new Date());
// post.setPublishedAt(new Date());
//
// post.setAuthoredBy(this.userDAO.getCurrentUser());
// post.setCreatedBy(this.userDAO.getCurrentUser());
// post.setUpdatedBy(this.userDAO.getCurrentUser());
//
// post.setCategories(this.categoryRepository.findAll());
// post.setTags(this.tagRepository.findAll());
//
// this.postRepository.save(post);