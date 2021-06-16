package com.androjava.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.entity.CourseSubCategory;

@Component
public class CheckUrlDatabase {
	

	@Autowired
	private ServicesImple servicesImple;
	
	public boolean checkUrl(String Url)
	{
			//	CHECK URL TO COURSE-CATEGORY
			CourseCategoy courseCategoryUrl = this.servicesImple.findByCourseCategoryUrl(Url);
			
			CourseSubCategory subCategoryUrl = this.servicesImple.findyBySubCategoryUrl(Url);
			
			CourseChapters ChapterUrl = this.servicesImple.findByChapterUrlName(Url);
			
			if(courseCategoryUrl == null && subCategoryUrl == null && ChapterUrl == null)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	

}
