package com.dojo.snapline.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.snapline.models.Picture;
import com.dojo.snapline.models.User;

@Repository
public interface PictureRepository extends CrudRepository <Picture, Long>{
//	// get all pictures
	List<Picture> findAll();
	
//	// all pictures ordered chronologically
//	List<Picture> findAllOrderBycreatedAtDesc();
//	// all pictures by user
//	List<Picture> findAllByUser (User owner);
}
