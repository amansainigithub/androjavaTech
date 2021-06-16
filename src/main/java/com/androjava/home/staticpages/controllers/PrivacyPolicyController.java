package com.androjava.home.staticpages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androjava.helper.NavbarHelper;

@Controller
public class PrivacyPolicyController {
	
	@Autowired
	private NavbarHelper navbarHelper;
	
	@RequestMapping("/privacy-policy")
	public String privacyPolicy(Model model)
	{
		//Fetch Header
		model.addAttribute("courseCategory", navbarHelper.getNavbarData());
		
		
		model.addAttribute("title", "AndrojavaTech4u Privacy policy");
		return "/staticPages/privacy-policy";
	}

}
