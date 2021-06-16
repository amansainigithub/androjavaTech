package com.androjava.home.staticpages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
public class SiteMapController {
	
	@RequestMapping(path = "/sitemap.xml", produces =APPLICATION_XML_VALUE )
	public String siteMap()
	{
		return "/sitemap.xml";
	}

}
