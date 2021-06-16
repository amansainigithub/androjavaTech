package com.androjava.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.androjava.admin.repository.ContactFormRepository;
import com.androjava.admin.repository.CourseCategoryRepository;
import com.androjava.admin.repository.CourseChapterRepository;
import com.androjava.admin.repository.CourseSubCategoryRepository;
import com.androjava.admin.repository.ImageHubRepository;
import com.androjava.admin.repository.LoginRepository;
import com.androjava.admin.repository.UserQuestionRepository;
import com.androjava.entity.Admin;
import com.androjava.entity.ContactForm;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.entity.CourseSubCategory;
import com.androjava.entity.ImageHub;
import com.androjava.entity.UserQuestions;

import net.bytebuddy.asm.Advice.This;

@Service
public class ServicesImple implements Services {

	@Autowired
	private LoginRepository loginRepository; 
	
	@Autowired
	private CourseCategoryRepository  courseCategoryRepository;
	
	@Autowired
	private CourseSubCategoryRepository courseSubCategoryRepository; 
	
	
	@Autowired
	private CourseChapterRepository courseChapterRepository; 
	
	@Autowired
	private ImageHubRepository imageHubRepository;
	
	@Autowired
	private ContactFormRepository contactFormRepository;
	
	
	@Autowired
	private UserQuestionRepository userQuestionRepository;
	
	
	
	@Override
	public Admin findByUserNameAndPassword(String username, String password) {
	
		return this.loginRepository.findByadminNameAndAdminPassword(username, password);
	}

	@Override
	public CourseCategoy saveCourseCategory(CourseCategoy courseCategoy) {
		return this.courseCategoryRepository.save(courseCategoy);
	}

	@Override
	public List<CourseCategoy> findAllCourseCategory() {
		return this.courseCategoryRepository.findAll();
	}

	@Override
	public CourseCategoy findByCourseId(int courseid) {
		Optional<CourseCategoy> findById = this.courseCategoryRepository.findById(courseid);
		return findById.get();
	}

	@Override
	public CourseSubCategory saveCourseSubCategory(CourseSubCategory courseSubCategory) {
		return this.courseSubCategoryRepository.save(courseSubCategory);
	}

	@Override
	public List<CourseSubCategory> findAllCourseSubCategory() {
		return this.courseSubCategoryRepository.findAll();
	}

	@Override
	public CourseSubCategory findSubCategoryById(int subCategoryId) {
		Optional<CourseSubCategory> findById = this.courseSubCategoryRepository.findById(subCategoryId);
		return findById.get();
	}

	@Override
	public CourseChapters saveCourseChapter(CourseChapters courseChapters) {
		return this.courseChapterRepository.save(courseChapters);
	}

	@Override
	public List<CourseCategoy> findTopCourseCategoryByDescendingOrder() {
		return this.courseCategoryRepository.findTop10ByOrderByCatIdDesc();
		
	}

	@Override
	public CourseCategoy findByCourseCategoryName(String categoryname) {
		return this.courseCategoryRepository.findBycategoryName(categoryname);
	}

	@Override
	public CourseChapters findByChapterUrlName(String chapterName) {
		return this.courseChapterRepository.findBychapterUrl(chapterName);
	}

	@Override
	public CourseCategoy findByCourseCategoryUrl(String categoryUrl) {
	return this.courseCategoryRepository.findBycategoryUrl(categoryUrl);
	}

	@Override
	public CourseSubCategory findyBySubCategoryUrl(String subCategoryUrl) {
		return this.courseSubCategoryRepository.findBysubcatUrl(subCategoryUrl);
	}

	@Override
	public ImageHub saveImageToImageHub(ImageHub imageHub) {
		return this.imageHubRepository.save(imageHub);
	}

	@Override
	public List<ImageHub> findTop10ImagesinImageHub() {
		return this.imageHubRepository.findTop10ByOrderByIdDesc();
	}

	@Override
	public List<ImageHub> findByImagesViaSearching(String imageName) {
		return this.imageHubRepository.findByimageNamesContaining(imageName);
	}

	@Override
	public Page<CourseChapters> pagenation(int subcatid, Pageable pageable) {
		return this.courseChapterRepository.findChaptersBysubcatId(subcatid, pageable);
	}

	@Override
	public List<CourseChapters> findAllCourseChapters() {
		return this.courseChapterRepository.findAll();
	}

	@Override
	public CourseChapters findByCourseCategoryId(String courseCategoryId) {
		return this.courseChapterRepository.findBycategoryId(courseCategoryId);
	}

	@Override
	public void deleteByCourseId(int corseCategoryId) {
		this.courseCategoryRepository.deleteById(corseCategoryId);
		
	}

	@Override
	public void deleteSubCategoryById(int subCategoryId) {
		this.courseSubCategoryRepository.deleteById(subCategoryId);
	}

	@Override
	public Page<CourseCategoy> findAllCourseCategoryPageable(Pageable pageable) {
		return this.courseCategoryRepository.findAll(pageable);
	}

	@Override
	public Page<CourseSubCategory> findAllSubCategoryPageable(Pageable pageable) {
		return this.courseSubCategoryRepository.findAll(pageable);
	}

	@Override
	public Page<CourseChapters> findAllChaptersPagenation(Pageable pageable) {
		return this.courseChapterRepository.findAll(pageable);
	}

	@Override
	public CourseChapters findByChapterId(Long chapterId) {
		return this.courseChapterRepository.findById(chapterId).get();
	}

	@Override
	public void deleteChapterById(Long chapterId) {
		this.courseChapterRepository.deleteById(chapterId);
		
	}

	@Override
	public List<CourseChapters> findAllChaptresByCategoryId(String categoryId) {
		return this.courseChapterRepository.findByCategoryId(categoryId.trim());
	}

	@Override
	public ContactForm saveContactFormData(ContactForm contactForm) {
		return this.contactFormRepository.save(contactForm);
	}

	@Override
	public UserQuestions saveUserQuestion(UserQuestions userQuestions) {
		return this.userQuestionRepository.save(userQuestions);
	}

	@Override
	public Page<UserQuestions> findAllUserQuestions(Pageable pageable) {
		return this.userQuestionRepository.findAll(pageable);
	}

	@Override
	public void deleteUserQuestion(Long questionId) {
	this.userQuestionRepository.deleteById(questionId);
		
	}

	@Override
	public Page<ContactForm> findAllContactStudent(Pageable pageable) {
		return this.contactFormRepository.findAll(pageable);
	}

	@Override
	public void deletContactQueryById(Long contactId) {
		this.contactFormRepository.deleteById(contactId);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
