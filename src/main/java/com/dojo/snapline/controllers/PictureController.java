package com.dojo.snapline.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.dojo.snapline.services.UserService;

public class PictureController {
	@Autowired
	private PhotoService pService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator

	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allAlbums", this.pService.getAllAlbums());
		return "index.jsp";
	}
}
