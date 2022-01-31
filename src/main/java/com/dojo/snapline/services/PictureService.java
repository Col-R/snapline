package com.dojo.snapline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.snapline.models.Picture;
import com.dojo.snapline.models.User;
import com.dojo.snapline.repositories.PictureRepository;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pRepo;
	
	public void uploadPic(User user, String url, String desc) {
		Picture newPic = new Picture (url, desc, user);
		this.pRepo.save(newPic);
	}
//	public List<Picture> userPictures (User user){
//		return this.pRepo.findAllByUser(user);
//	}
	
	public List<Picture> allPictures(){
		return (List<Picture>) this.pRepo.findAll();
	}
}
