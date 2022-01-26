package com.dojo.snapline.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.dojo.snapline.services.PictureService;
import com.dojo.snapline.services.UserService;
import com.dojo.snapline.validators.UserValidator;

public class PictureController {
	@Autowired
	private PictureService pService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;

}
