package com.androjava.home.staticpages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androjava.helper.NavbarHelper;

@Controller
public class DisclaimerController {
	
	@Autowired
	private NavbarHelper navbarHelper;
	
	
	@RequestMapping("/disclaimer")
	public String contact(Model model)
	{
		model.addAttribute("title", "AndrojavaTech4u Disclaimer");
		
		//Fetch Header
		model.addAttribute("courseCategory", navbarHelper.getNavbarData());
				
				
		return "/staticPages/disclaimer";
	}

}
