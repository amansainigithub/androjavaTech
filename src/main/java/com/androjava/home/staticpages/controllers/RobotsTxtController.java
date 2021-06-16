package com.androjava.home.staticpages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RobotsTxtController {
	
	@RequestMapping(path = "robots.txt")
	public String robotsTxt()
	{
		return "/robots.txt";
	}

}
