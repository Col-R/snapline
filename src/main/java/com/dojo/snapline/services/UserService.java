package com.dojo.snapline.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.snapline.models.User;
import com.dojo.snapline.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public User registerUser(User user) {
		// generate the hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// set the hashed password on the users password field
		user.setPassword(hash);
		//save that user password and the user object to the database
		return this.uRepo.save(user);
	}
}
