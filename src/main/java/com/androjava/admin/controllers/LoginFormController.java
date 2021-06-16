package com.androjava.admin.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/adminlogin")
public class LoginFormController {
	
	@RequestMapping("/login" )
	public String loginPage(HttpSession session)
	{
		System.out.println("Login works....");
		return "/admin/login";
	}

}
