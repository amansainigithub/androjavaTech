package com.androjava.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.androjava.entity.ImageHub;

public interface ImageHubRepository  extends JpaRepository<ImageHub, Long>{
	
	public List<ImageHub> findTop10ByOrderByIdDesc();
	
	public List<ImageHub> findByimageNamesContaining(String imageName);

}
 