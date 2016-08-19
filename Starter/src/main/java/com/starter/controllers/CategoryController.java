package com.starter.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starter.dao.CategoryDAO;
import com.starter.entities.CategoryEntity;
import com.starter.forms.CategoryForm;

@Controller
public class CategoryController extends BaseController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		Iterable<CategoryEntity> categories = this.categoryDAO.select(new Sort(Direction.ASC, "name"));
		model.addAttribute("categories", categories);
		return "categories.list";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String details(@PathVariable UUID id, Model model) {
		CategoryEntity category = this.categoryDAO.selectById(id);

		if (category == null) {
			return "redirect:/404";
		}

		model.addAttribute("category", category);
		return "categories.details";
	}

	@RequestMapping(value = "/categories/new", method = RequestMethod.GET)
	public String newCategory(Model model) {
		model.addAttribute("categoryForm", new CategoryForm());
		return "categories.new";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public String createCategory(HttpServletResponse response, Model model, @Valid CategoryForm categoryForm, BindingResult binding, RedirectAttributes attr) {

		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("org.springframework.validation.BindingResult.categoryForm", binding);
			return "categories.new";
		}

		this.categoryDAO.create(categoryForm);

		return "redirect:/categories";
	}

	@RequestMapping(value = "/categories/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable UUID id, HttpServletResponse response, Model model) {
		CategoryEntity category = this.categoryDAO.selectById(id);

		if (category == null) {
			return "redirect:/404";
		}

		model.addAttribute("category", category);

		if (model.containsAttribute("categoryForm")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			CategoryForm categoryForm = (CategoryForm) this.categoryDAO.edit(category, CategoryForm.class);
			model.addAttribute("categoryForm", categoryForm);
		}

		return "categories.edit";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable UUID id, Model model, @Valid CategoryForm categoryForm, BindingResult binding, RedirectAttributes attr) {
		CategoryEntity category = this.categoryDAO.selectById(id);

		if (category == null) {
			return "redirect:/404";
		}

		if (binding.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.categoryForm", binding);
			attr.addFlashAttribute("categoryForm", categoryForm);
			return String.format("redirect:/categories/%s/edit", id);
		}

		this.categoryDAO.update(category, categoryForm);

		return "redirect:/categories";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable UUID id) {
		CategoryEntity category = this.categoryDAO.selectById(id);
		if (category != null) {
			this.categoryDAO.delete(category);
		}
		return "redirect:/categories";
	}

}
