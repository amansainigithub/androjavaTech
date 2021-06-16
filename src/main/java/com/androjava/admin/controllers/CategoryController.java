package com.androjava.admin.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.helper.CheckUrlDatabase;
import com.androjava.helper.Message;
import com.androjava.helper.SaveImage;

@Controller
@RequestMapping("/admin/adminpanel")
public class CategoryController {
	
	@Autowired
	private CheckUrlDatabase checkUrlDatabase;
	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private SaveImage saveImage;
	
	@RequestMapping("/createCategoryForm")
	public String categoryForm()
	{
		System.out.println("show form working...");
		// return "/admin/login";
		return "/admin/categoryForm";
	}
	
	
	
	@RequestMapping("/createCategory")
	public String createCategory(@ModelAttribute CourseCategoy courseCategoy,
								@RequestParam("file") MultipartFile file 
								,HttpServletRequest request) throws IOException
	{
		HttpSession session = request.getSession();
		try {
			
			boolean checkUrl = this.checkUrlDatabase.checkUrl(courseCategoy.getCategory_url().replace(" ", "-").trim());
			
			if(checkUrl == false)
			{
				Message message=new Message("URL is already Used !", "alert-danger");
				session.setAttribute("message", message);
				return "redirect:createCategoryForm";
			}
			
			
			
			//replace URL
			courseCategoy.setCategory_url(courseCategoy.getCategory_url().replace(" ","-"));
			
			//fetch imageName
			String imageName = file.getOriginalFilename();
			
			//save image to directory
			boolean saveOrnot = this.saveImage.writingImage("categoryImages", file);
			
			//set image name
			courseCategoy.setCatImageName(imageName);
			
			
			CourseCategoy saveCourseCategory = this.servicesImple.saveCourseCategory(courseCategoy);
			
			//set message status
			
			Message message=new Message("data successfully inserted", "alert-success");
			session.setAttribute("message", message);
			
		} catch (Exception e) {
			e.printStackTrace();
			Message message=new Message("data not inserted", "alert-danger");
		}
		
		return "redirect:createCategoryForm";
		
	}
	
	
	

}









