package com.starter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starter.dao.UserDAO;
import com.starter.entities.PrivilegeEntity;
import com.starter.entities.RoleEntity;
import com.starter.entities.UserEntity;

@Controller
public class MainController {

	@Autowired
	private UserDAO userDAO;

	@PreAuthorize("hasRole('ROLE_POSTS_USER')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		UserEntity currentUser = this.userDAO.getCurrentUser();

		System.out.println(currentUser.getFirstName());
		System.out.println(currentUser.getLastName());

		List<RoleEntity> roles = currentUser.getRoles();
		for (RoleEntity role : roles) {
			System.out.print("role: ");
			System.out.println(role.getName());
			for (PrivilegeEntity privilege : role.getPrivileges()) {
				System.out.print("privilege: ");
				System.out.println(privilege.getName());
			}

		}

		return "main";
	}

}
