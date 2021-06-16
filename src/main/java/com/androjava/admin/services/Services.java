package com.androjava.admin.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.androjava.entity.Admin;
import com.androjava.entity.ContactForm;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.entity.CourseSubCategory;
import com.androjava.entity.ImageHub;
import com.androjava.entity.UserQuestions;

public interface Services {
	
	public Admin findByUserNameAndPassword(String username,String password);
	
	
	//Course Category
	public CourseCategoy saveCourseCategory(CourseCategoy courseCategoy);
	public List<CourseCategoy> findAllCourseCategory();
	public CourseCategoy findByCourseId(int courseid);
	public List<CourseCategoy> findTopCourseCategoryByDescendingOrder(); 
	public CourseCategoy findByCourseCategoryName(String categoryname);
	public CourseCategoy findByCourseCategoryUrl(String categoryUrl);
	public void deleteByCourseId(int corseCategoryId);
	public Page<CourseCategoy> findAllCourseCategoryPageable(Pageable pageable);
	
	
	//Course Sub category
	public CourseSubCategory saveCourseSubCategory(CourseSubCategory courseSubCategory);
	public List<CourseSubCategory> findAllCourseSubCategory();
	public CourseSubCategory findSubCategoryById(int subCategoryId);
	public CourseSubCategory findyBySubCategoryUrl(String subCategoryUrl);
	public void deleteSubCategoryById(int subCategoryId);
	public Page<CourseSubCategory> findAllSubCategoryPageable(Pageable pageable);
	
	
	//course Chapter
	public CourseChapters saveCourseChapter(CourseChapters courseChapters);
	public CourseChapters findByChapterUrlName(String chapterName);
	public Page<CourseChapters> pagenation(int subcatid,Pageable pageable);
	public List<CourseChapters> findAllCourseChapters();
	public CourseChapters findByCourseCategoryId(String courseCategoryId);
	public Page<CourseChapters> findAllChaptersPagenation(Pageable pageable);
	public CourseChapters findByChapterId(Long chapterId);
	public void deleteChapterById(Long chapterId);
	public List<CourseChapters> findAllChaptresByCategoryId(String categoryId);
	
	
	
	
	//ImageHub
	public ImageHub saveImageToImageHub(ImageHub imageHub);
	public List<ImageHub> findTop10ImagesinImageHub();
	public List<ImageHub> findByImagesViaSearching(String imageName);
	
	
	
	//ContactForm (User Query Course)
	public ContactForm saveContactFormData(ContactForm contactForm);
	public Page<ContactForm> findAllContactStudent(Pageable pageable);
	public void deletContactQueryById(Long contactId);
	
	//User-Questions
	public UserQuestions saveUserQuestion(UserQuestions userQuestions);
	public Page<UserQuestions> findAllUserQuestions(Pageable pageable);
	public void deleteUserQuestion(Long questionId);
	
	

}
