package com.dojo.snapline.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.snapline.models.User;
import com.dojo.snapline.services.PictureService;
import com.dojo.snapline.services.UserService;

@Controller
@RequestMapping("/home")
public class PictureController {
	@Autowired
	private PictureService pService;
	@Autowired
	private UserService uService;
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

	@GetMapping("")
	public String dashboard (Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		
		User user = uService.getOneUser((Long)session.getAttribute("user__id"));
		viewModel.addAttribute("user", user);
//		viewModel.addAttribute("allUsers", this.uService.getAllUsers());
		
		
		List<User> users = uService.getAllUsers();
		viewModel.addAttribute("users", users);
		
		viewModel.addAttribute("pictures", this.pService.userPictures(user));
		
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/new") // upload page
	public String addPicture (Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		return "newUpload.jsp";
	}
	
	@PostMapping("/upload") // image upload
	public String upload(@RequestParam("image") MultipartFile file, @RequestParam("description") String description, HttpSession session, RedirectAttributes redirectAttr ) {
		User user = uService.getOneUser((Long)session.getAttribute("user__id"));
		if (file.isEmpty()) {
			redirectAttr.addFlashAttribute("message", "Upload field cannot be empty");
			return "redirect:/home/new";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/images/" + file.getOriginalFilename();
			this.pService.uploadPic(user, url, description);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	

	
	
	
}
