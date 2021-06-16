package com.androjava.home.controllers;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.UserQuestions;

@Controller
public class UserQuestionController {
	
	@Autowired
	private ServicesImple serviceImple; 
	
	@RequestMapping(value="/question",method = RequestMethod.POST)
	public String userQuestionHandler(@ModelAttribute UserQuestions userQuestions,HttpServletResponse response)
	{
		//save user questions to database
		UserQuestions saveUserQuestion = this.serviceImple.saveUserQuestion(userQuestions);
		
		try {
			Thread.sleep(2000);
			response.sendRedirect("http://www.androjavatech4u.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "index";
	}

}
