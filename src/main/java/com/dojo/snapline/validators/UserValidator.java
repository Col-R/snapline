package com.dojo.snapline.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.dojo.snapline.models.User;
import com.dojo.snapline.repositories.UserRepository;


@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo; // checking if a user's info is already registered
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(!user.getPassword().equals(user.getConfirmPassword())) { // ! for not equals
			errors.rejectValue("password", "match", "doesn't match!");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "unique", "Email already in use");
		}
	}
}
