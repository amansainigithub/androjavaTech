package com.androjava.admin.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.androjava.entity.CourseSubCategory;
import com.androjava.helper.CheckUrlDatabase;
import com.androjava.helper.Message;
import com.androjava.helper.SaveImage;

@Controller
@RequestMapping("/admin/adminpanel")
public class SubCategoryController {
	
	@Autowired
	private CheckUrlDatabase checkUrlDatabase;
	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private SaveImage saveImage;
	
	
	@RequestMapping("/showSubCategoryForm")
	public String categoryForm(Model model)
	{
		//Fetching Course Category List
		List<CourseCategoy> findAllCourseCategory = this.servicesImple.findAllCourseCategory();
		
		//set List in Model
		model.addAttribute("categoryList", findAllCourseCategory);
		
		
		return "/admin/subCategoryForm";
	}
	
	@RequestMapping(value="/createSubCategory",method = RequestMethod.POST)
	public String createSubCategory(@ModelAttribute CourseSubCategory courseSubCategory,
									@RequestParam("file") MultipartFile file ,
									@RequestParam("courseCategoryId")Integer courseCategoryId,
									HttpServletRequest request )
	{
		HttpSession session = request.getSession();
		
		try {
			
			if(String.valueOf(courseCategoryId).equals("0"))
			{
				Message message=new Message("please select category", "alert-warning");
				session.setAttribute("message", message);
				throw new Exception("please select category");
			}
			
			boolean checkUrl = this.checkUrlDatabase.checkUrl(courseSubCategory.getSubcatUrl().replace(" ", "-").trim());
			
			if(checkUrl == false)
			{
				Message message=new Message("URL is already Used !", "alert-danger");
				session.setAttribute("message", message);
				return "redirect:createCategoryForm";
			}
			
			
			courseSubCategory.setSubcatUrl(courseSubCategory.getSubcatUrl().replace(" ", "-"));
			
			//Course category Details fetch By course ID
			CourseCategoy courseCategory = this.servicesImple.findByCourseId(courseCategoryId);
			
			//set image name
			courseSubCategory.setSubcatImageName(file.getOriginalFilename());
			
			//writing image to dir....
			boolean writingImage = this.saveImage.writingImage("subcategory_images", file);
			
			
			courseSubCategory.setCourseCategoy(courseCategory);
			
			CourseSubCategory saveCourseSubCategory = this.servicesImple.saveCourseSubCategory(courseSubCategory);
			
			if(saveCourseSubCategory==null)
			{
				Message message=new Message("something went wrong !", "alert-danger");
				session.setAttribute("message", message);
			}
			else
			{
				Message message=new Message("category created successfully", "alert-success");
				session.setAttribute("message", message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:showSubCategoryForm";
		}
		
		return "redirect:showSubCategoryForm";
	}
	
	
	

}
