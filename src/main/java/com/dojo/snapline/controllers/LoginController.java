package com.dojo.snapline.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.snapline.models.User;
import com.dojo.snapline.services.UserService;
import com.dojo.snapline.validators.UserValidator;

@Controller
public class LoginController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String landing(@ModelAttribute("user")User user) {
		return "landing.jsp";
	}
	@PostMapping("/registerUser")
	public String register (@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user,result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/dashboard";
	}
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail") String email, @RequestParam("lpassword")String password, RedirectAttributes redirectAttr) {
		if (!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/dashboard";
		}
		User user = this.uService.getUserByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/";
	}
	@GetMapping("dashboard")
	public String dashboard (Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		return "dashboard.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
