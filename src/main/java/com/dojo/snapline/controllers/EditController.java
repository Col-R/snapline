package com.dojo.snapline.controllers;


import javax.servlet.http.HttpSession;
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
	public String editUser(@PathVariable("id")Long id, @ModelAttribute("user")User user, Model viewModel, HttpSession session) {
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		if(session.getAttribute("user__id") != id) {
			return "redirect:/";
		}
		return "editUser.jsp";
	}
	
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("user")User user, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("user", this.uService.getOneUser(id));
			System.out.println(result);
			return "editUser.jsp";
			
		}
		this.uService.editUser(user);
		return "redirect:/home";
	}	
}
// ignore validations
// make custom validations ++
// write method in user class, EditValidator()

// make obj in above with username, first, last. Init as "0", check if(username.length()< 3) 
// return UserVal
// add var for validations = 0. Add to it, if var > 0, flash error.