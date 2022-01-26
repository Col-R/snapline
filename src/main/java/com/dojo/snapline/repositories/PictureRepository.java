package com.dojo.snapline.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dojo.snapline.models.Picture;

@Repository
public interface PictureRepository extends CrudRepository <Picture, Long>{
	List<Picture> findAll();
	List<Picture> findAllOrderByCreated_AtDesc();
}
