package com.starter.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.starter.dao.UserDAO;
import com.starter.entities.UserEntity;
import com.starter.forms.UserForgotPasswordForm;
import com.starter.forms.UserLoginForm;
import com.starter.forms.UserRegistrationForm;
import com.starter.validators.UserForgotPasswordValidator;
import com.starter.validators.UserRegistrationValidator;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserDAO						userDAO;

	@Autowired
	private PasswordEncoder				passwordEncoder;

	@Autowired
	private UserRegistrationValidator	userRegistrationValidator;

	@Autowired
	private UserForgotPasswordValidator	userForgotPasswordValidator;

	@InitBinder("UserRegistrationValidator")
	public void initUserNameAvailableValidatorBinder(WebDataBinder binder) {
		binder.addValidators(this.userRegistrationValidator);
	}

	@InitBinder("UserForgotPasswordValidator")
	public void initUserForgotPasswordValidatorBinder(WebDataBinder binder) {
		binder.addValidators(this.userForgotPasswordValidator);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("userLoginForm", new UserLoginForm());
		return "login.login";
	}

	@RequestMapping(value = "/login/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userRegistrationForm", new UserRegistrationForm());
		return "login.registration";
	}

	@RequestMapping(value = "/login/registration", method = RequestMethod.POST)
	public String register(HttpServletResponse response, Model model, @Valid @ModelAttribute("UserRegistrationValidator") UserRegistrationForm userRegistrationForm, BindingResult binding, RedirectAttributes attr) {

		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("org.springframework.validation.BindingResult.userRegistrationForm", binding);
			model.addAttribute("userRegistrationForm", userRegistrationForm);
			return "login.registration";
		}

		userRegistrationForm.setPassword(this.passwordEncoder.encode(userRegistrationForm.getPassword()));
		this.userDAO.create(userRegistrationForm);

		return "redirect:/login";
	}

	@RequestMapping(value = "/login/forgot-password", method = RequestMethod.GET)
	public String forgotPassword(Model model) {
		model.addAttribute("userForgotPasswordForm", new UserForgotPasswordForm());
		return "login.forgot-password";
	}

	@RequestMapping(value = "/login/forgot-password", method = RequestMethod.POST)
	public String resetPassword(HttpServletResponse response, Model model, @Valid @ModelAttribute("UserForgotPasswordValidator") UserForgotPasswordForm userForgotPasswordForm, BindingResult binding, RedirectAttributes attr) {

		if (binding.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.addAttribute("org.springframework.validation.BindingResult.userForgotPasswordForm", binding);
			model.addAttribute("userForgotPasswordForm", userForgotPasswordForm);
			return "login.forgot-password";
		}

		UserEntity user = this.userDAO.selectByUserName(userForgotPasswordForm.getUserName());

		// send email

		attr.addFlashAttribute("emailAddress", user.getEmailAddress());

		return "redirect:/login/forgot-password/sent";
	}

	@RequestMapping(value = "/login/forgot-password/sent", method = RequestMethod.GET)
	public String forgotPasswordSent(Model model) {

		if (!model.containsAttribute("emailAddress")) {
			return "redirect:/login";
		}

		return "login.forgot-password-sent";
	}

}
