package com.androjava.home.staticpages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androjava.helper.NavbarHelper;

@Controller
public class TermsAndConditionsController {
	
	@Autowired
	private NavbarHelper navbarHelper;
	
	@RequestMapping("/terms-and-conditions")
	public String termsAndConditions(Model model) {
		
		//Fetch Header
				model.addAttribute("courseCategory", navbarHelper.getNavbarData());
		
		model.addAttribute("title", "AndrojavaTech4u Terms-and-Conditions");
		return "/staticPages/terms-and-conditions";
	}

}
