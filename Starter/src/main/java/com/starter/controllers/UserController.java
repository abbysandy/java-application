package com.starter.controllers;

import java.util.List;

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

import com.starter.entities.UserEntity;
import com.starter.forms.UserForm;
import com.starter.repositories.UserRepository;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		List<UserEntity> users = this.userRepository.findAll();
		model.addAttribute("users", users);
		return "users/list";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String detailsUser(Model model, @PathVariable int id) {
		UserEntity user = this.userRepository.findOne(id);

		if (user == null) {
			return "redirect:/404";
		}

		model.addAttribute("user", user);
		return "users/details";
	}

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "users/new";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String createUser(HttpServletResponse response, Model model, @Valid UserForm userForm, BindingResult binding) {
		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("user", userForm);
			return "users/new";
		}

		UserEntity user = new UserEntity();
		user.load(userForm);
		this.userRepository.save(user);

		return "redirect:/users";
	}

	@RequestMapping(value = "/users/{id}/edit", method = RequestMethod.GET)
	public String editUser(@PathVariable int id, HttpServletResponse response, Model model) {
		UserEntity user = this.userRepository.findOne(id);

		if (user == null) {
			return "redirect:/404";
		}

		model.addAttribute("user", user);

		if (model.containsAttribute("userForm")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			UserForm userForm = new UserForm(user);
			model.addAttribute("userForm", userForm);
		}

		return "users/edit";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable Integer id, Model model, @Valid UserForm userForm, BindingResult binding, RedirectAttributes attr) {
		UserEntity user = this.userRepository.findOne(id);

		if (user == null) {
			return "redirect:/404";
		}

		if (binding.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.userForm", binding);
			attr.addFlashAttribute("userForm", userForm);
			return String.format("redirect:/users/%d/edit", id);
		}

		user.load(userForm);
		this.userRepository.save(user);

		return "redirect:/users";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id) {
		UserEntity user = this.userRepository.findOne(id);
		if (user != null) {
			this.userRepository.delete(id);
		}
		return "redirect:/users";
	}

}
