package com.androjava.interceptors.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.Admin;



@Component
public class AdminInterceptor implements HandlerInterceptor{
	
	@Autowired
	private ServicesImple adminServicesImple; 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		try {
			String adminName = request.getParameter("adminName");
			String adminPassword = request.getParameter("adminPassword");
			
			
			Admin data = this.adminServicesImple.findByUserNameAndPassword(adminName, adminPassword);
			
			if(data != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("ad_Name" ,data.getAdminName());
				return true;
			}
			
			if(((String)request.getSession().getAttribute("ad_Name") != null))
					{
						return true;
					}
			
			if(((String)request.getSession().getAttribute("ad_Name") == null))
			{
				response.sendRedirect("/admin/adminlogin/login");
				return false;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		

			


	}
	
	
	

}
