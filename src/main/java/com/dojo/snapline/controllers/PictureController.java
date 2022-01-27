package com.dojo.snapline.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dojo.snapline.services.PictureService;
import com.dojo.snapline.services.UserService;
import com.dojo.snapline.validators.UserValidator;

@Controller
@RequestMapping("/home")
public class PictureController {
	@Autowired
	private PictureService pService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;

	@GetMapping("")
	public String dashboard (Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		return "dashboard.jsp";
	}
}
