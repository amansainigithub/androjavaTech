package com.androjava.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.androjava.entity.CourseCategoy;

public interface CourseCategoryRepository extends JpaRepository<CourseCategoy, Integer> {
	
	public List<CourseCategoy> findTop10ByOrderByCatIdDesc();
	
	public CourseCategoy findBycategoryName(String categoryName);
	
	public CourseCategoy findBycategoryUrl(String category_Url);

}
