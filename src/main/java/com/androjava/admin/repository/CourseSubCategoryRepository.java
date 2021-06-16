package com.androjava.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.androjava.entity.CourseSubCategory;

public interface CourseSubCategoryRepository extends JpaRepository<CourseSubCategory, Integer> {
	
	//public CourseSubCategory findBysubcatId(int subcatId);
	
	public CourseSubCategory findBysubcatUrl(String subcatUrl);

}
