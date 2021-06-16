package com.androjava.admin.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.entity.CourseSubCategory;
import com.androjava.helper.CheckUrlDatabase;
import com.androjava.helper.Message;
import com.androjava.helper.SaveImage;

@Controller
@RequestMapping("/admin/adminpanel")
public class ChapterController {
	
	@Autowired
	private CheckUrlDatabase checkUrlDatabase;
	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private SaveImage saveImage;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/chapterForm")
	public String showChapterForm(Model model)
	{
		
		//fetch sub category List
		List<CourseSubCategory> subCategoryList = this.servicesImple.findAllCourseSubCategory();
		
		//sub category list set in model
		model.addAttribute("subcategoryList", subCategoryList);
		
		return "/admin/chapterForm";
	}
	
	
	@RequestMapping(value="/createChapter" , method = RequestMethod.POST)
	public String createChapter(@ModelAttribute CourseChapters courseChapters,
								//@RequestParam("file")MultipartFile file,
								@RequestParam("subCategoryId")Integer subCategoryId
								)
	{
		
		
		
		try {
			
			if(String.valueOf(subCategoryId).equals("0"))
			{
				Message message=new Message("please select category", "alert-warning");
				session.setAttribute("message", message);
				throw new Exception("please select category");
			}
			
			boolean checkUrl = this.checkUrlDatabase.checkUrl(courseChapters.getChapterUrl().replace(" ", "-").trim());
			
			if(checkUrl == false)
			{
				Message message=new Message("URL is already Used !", "alert-danger");
				session.setAttribute("message", message);
				return "redirect:createCategoryForm";
			}
			
			//remove Space in chapter URL
			courseChapters.setChapterUrl(courseChapters.getChapterUrl().replace(" ", "-"));
			
			//courseChapters.setChapterImageName(file.getOriginalFilename());
			
			//get subCategory Object
			
			CourseSubCategory subCategoryData = this.servicesImple.findSubCategoryById(subCategoryId);
			
			
			//optional set sub-category ID 
			courseChapters.setSub_CategoryId(String.valueOf(subCategoryData.getSubcatId()));
			
			//optional set category ID
			CourseCategoy courseCategoy = subCategoryData.getCourseCategoy();
			courseChapters.setCategoryId(String.valueOf(courseCategoy.getCatId()));
			
			//writing image to dir....
			//boolean writingImage = this.saveImage.writingImage("chapterImages", file);
			
			
			//set sub category to course Chapter
			courseChapters.setCourseSubCategory(subCategoryData);
			
			CourseChapters saveCourseChapter = this.servicesImple.saveCourseChapter(courseChapters);
			
			
			if(saveCourseChapter == null)
			{
				Message message=new Message("something went wrong !", "alert-danger");
				session.setAttribute("message", message);
			}
			else
			{
				Message message=new Message("Chapter successfully created", "alert-success");
				session.setAttribute("message", message);
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:chapterForm";
		//return "/admin/chapterForm";
	}
	
	

}
