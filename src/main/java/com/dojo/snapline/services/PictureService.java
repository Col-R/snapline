package com.dojo.snapline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.snapline.models.Picture;
import com.dojo.snapline.repositories.PictureRepository;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pRepo;
	public list <Picture> getAllPictures(){
		return this.pRepo.findAll();
	}
	public Picture createPicture(Picture picture) {
		return this.pRepo.save(picture)
	}
}
