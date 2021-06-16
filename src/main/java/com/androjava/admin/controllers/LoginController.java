package com.androjava.admin.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.Admin;
import com.androjava.helper.Message;

@Controller
@RequestMapping("/admin/adminpanel")
public class LoginController {
	
	@Autowired
	private ServicesImple adminServicesImple; 
	
	
	@RequestMapping("/dologin")
	public String doAdminLogin(@ModelAttribute Admin admin,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Admin data = this.adminServicesImple.findByUserNameAndPassword(admin.getAdminName(), admin.getAdminPassword());
		HttpSession session = request.getSession();
		
		
		
		System.out.println(data);
		if(data==null)
		{
			 Message message=new Message("invalid crenditials", "alert-danger");
			 session.setAttribute("message", message);
			 return "/admin/login";
		}
		
		if(data.isAdminStatus()==false)
		{
			return "redirect:login";
		}
		else
		{
			return "redirect:adminHome";
		}
		
		
	}
	
	@RequestMapping("/adminHome")
	public String adminHome(HttpSession session)
	{

		return "/admin/adminDashboard";
	}
	
	
	@RequestMapping("/signout" )
	public String signout(HttpSession session)
	{	
		session.removeAttribute("ad_Name");
		return "/admin/login";
	}
	

}
