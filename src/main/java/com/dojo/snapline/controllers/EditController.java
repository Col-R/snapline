package com.dojo.snapline.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.snapline.models.User;
import com.dojo.snapline.services.UserService;



@Controller
public class EditController {
	@Autowired
	private UserService uService;
	
	@GetMapping("edit/{id}")
	public String editUser(@PathVariable("id")Long id, @ModelAttribute("user")User user, Model viewModel) {
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "editUser.jsp";
	}
	
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("user")User user, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("user", this.uService.getOneUser(id));
			return "editUser.jsp";
		}
		this.uService.editUser(user);
		return "redirect:/home";
	}	
}
