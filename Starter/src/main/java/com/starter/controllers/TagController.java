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

import com.starter.dao.TagDAO;
import com.starter.entities.TagEntity;
import com.starter.forms.TagForm;

@Controller
public class TagController extends BaseController {

	@Autowired
	private TagDAO tagDAO;

	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		Iterable<TagEntity> tags = this.tagDAO.select(new Sort(Direction.ASC, "name"));
		model.addAttribute("tags", tags);
		return "tags.list";
	}

	@RequestMapping(value = "/tags/{id}", method = RequestMethod.GET)
	public String details(@PathVariable UUID id, Model model) {
		TagEntity tag = this.tagDAO.selectById(id);

		if (tag == null) {
			return "redirect:/404";
		}

		model.addAttribute("tag", tag);
		return "tags.details";
	}

	@RequestMapping(value = "/tags/new", method = RequestMethod.GET)
	public String newTag(Model model) {
		model.addAttribute("tagForm", new TagForm());
		return "tags.new";
	}

	@RequestMapping(value = "/tags", method = RequestMethod.POST)
	public String createTag(HttpServletResponse response, Model model, @Valid TagForm tagForm, BindingResult binding, RedirectAttributes attr) {

		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("org.springframework.validation.BindingResult.tagForm", binding);
			return "tags.new";
		}

		this.tagDAO.create(tagForm);

		return "redirect:/tags";
	}

	@RequestMapping(value = "/tags/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable UUID id, HttpServletResponse response, Model model) {
		TagEntity tag = this.tagDAO.selectById(id);

		if (tag == null) {
			return "redirect:/404";
		}

		model.addAttribute("tag", tag);

		if (model.containsAttribute("tagForm")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			TagForm tagForm = (TagForm) this.tagDAO.edit(tag, TagForm.class);
			model.addAttribute("tagForm", tagForm);
		}

		return "tags.edit";
	}

	@RequestMapping(value = "/tags/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable UUID id, Model model, @Valid TagForm tagForm, BindingResult binding, RedirectAttributes attr) {
		TagEntity tag = this.tagDAO.selectById(id);

		if (tag == null) {
			return "redirect:/404";
		}

		if (binding.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.tagForm", binding);
			attr.addFlashAttribute("tagForm", tagForm);
			return String.format("redirect:/tags/%s/edit", id);
		}

		this.tagDAO.update(tag, tagForm);

		return "redirect:/tags";
	}

	@RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable UUID id) {
		TagEntity tag = this.tagDAO.selectById(id);
		if (tag != null) {
			this.tagDAO.delete(tag);
		}
		return "redirect:/tags";
	}

}
