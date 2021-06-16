package com.androjava.home.staticpages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androjava.helper.NavbarHelper;

@Controller
public class AbousUsController {
	
	@Autowired
	private NavbarHelper navbarHelper;
	
	@RequestMapping("about-us")
	public String AbooutUs(Model model)
	{
		model.addAttribute("title", "AndrojavaTech4u About-Us");
		
		//Fetch Header
		model.addAttribute("courseCategory", navbarHelper.getNavbarData());
		
		
		return "/staticPages/about-us";
	}

}
