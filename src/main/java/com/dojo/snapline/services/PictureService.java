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
	
	public List <Picture> getAllPictures(){
		return this.pRepo.findAll();
	}
	
	
	public void uploadPic(User owner, String url, String desc) {
		Picture newPic = newPicture(owner, url, desc); // getting error here, unsure why.
		this.pRepo.save(newPic);
	}
}
