package com.androjava.admin.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.androjava.entity.CourseChapters;

public interface CourseChapterRepository extends JpaRepository<CourseChapters,Long> {
	
	
	public CourseChapters findBychapterUrl(String chapterName);
	
	@Query("from CourseChapters as c where c.courseSubCategory.courseCategoy.catId=:catId")
	public Page<CourseChapters> findChaptersBysubcatId(@Param("catId")int catId,Pageable pageable);
	
	public CourseChapters findBycategoryId(String categoryId);
	
	public List<CourseChapters> findByCategoryId(String categoryId);
	

}
