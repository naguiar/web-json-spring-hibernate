/**
 * 
 */
package com.naguiar.catalog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naguiar.catalog.model.User;
import com.naguiar.catalog.service.LoginService;

/**
 * @author naty
 * 
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	/**
	 * Form
	 * @return
	 */
	@RequestMapping("newLogin")
	public String form() {
		return "login/form";
	}

	/**
	 * Login
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user, HttpSession session) {

		if (loginService.login(user) != null) {
			session.setAttribute("userLogged", user);
			return "home/home";
		}

		return "redirect:newLogin";
	}

	/**
	 * Logout
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:newLogin";
	}
}
