package com.starter.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		List<UserEntity> users = this.userDAO.select();
		model.addAttribute("users", users);
		return "users.list";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String detailsUser(Model model, @PathVariable int id) {
		UserEntity user = this.userDAO.selectById(id);

		if (user == null) {
			return "redirect:/404";
		}

		model.addAttribute("user", user);
		return "users.details";
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "users.new";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String createUser(HttpServletResponse response, Model model, UserForm userForm, RedirectAttributes attr) {

		BindingResult bindingResult = this.userDAO.validate(null, userForm);

		if (bindingResult.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
			model.addAttribute("user", userForm);
			return "users.new";
		}

		this.userDAO.create(userForm);

		return "redirect:/users";
	}

	@RequestMapping(value = "/users/{id}/edit", method = RequestMethod.GET)
	public String editUser(@PathVariable int id, HttpServletResponse response, Model model) {
		UserEntity user = this.userDAO.selectById(id);

		if (user == null) {
			return "redirect:/404";
		}

		model.addAttribute("user", user);

		if (model.containsAttribute("userForm")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			UserForm userForm = (UserForm) this.userDAO.edit(user);
			model.addAttribute("userForm", userForm);
		}

		return "users.edit";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable Integer id, Model model, UserForm userForm, RedirectAttributes attr) {
		UserEntity user = this.userDAO.selectById(id);

		if (user == null) {
			return "redirect:/404";
		}

		BindingResult bindingResult = this.userDAO.validate(user, userForm);

		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
			attr.addFlashAttribute("userForm", userForm);
			return String.format("redirect:/users/%d/edit", id);
		}

		this.userDAO.update(user, userForm);

		return "redirect:/users";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id) {
		UserEntity user = this.userDAO.selectById(id);
		if (user != null) {
			this.userDAO.delete(user);
		}
		return "redirect:/users";
	}

}
