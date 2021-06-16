package com.androjava.home.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.entity.CourseSubCategory;
import com.androjava.entity.ManageUrl;
import com.androjava.helper.NavbarHelper;

@Controller
public class IndexControlller {

	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private NavbarHelper navbarHelper;
	
	@GetMapping
	public String indexPage(Model model)
	{
		try {
			//set title
			model.addAttribute("title", "AndrojavaTech4u");
			
			//Fetch Header
			model.addAttribute("courseCategory", navbarHelper.getNavbarData());
			
			//get Course-Category List
			model.addAttribute("courseCaegoryList", this.servicesImple.findAllCourseCategory());
			
			
			model.addAttribute("courseList", null);
			
			
			System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/index";
	}
	

	

	
}
