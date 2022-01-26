package com.dojo.snapline.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dojo.snapline.models.Picture;

@Repository
public interface PictureRepository {
	List<Picture> findAll();
	List<Picture> findAllOrderByCreated_AtDesc();
}
