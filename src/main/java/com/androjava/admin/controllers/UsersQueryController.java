package com.androjava.admin.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.UserQuestions;
import com.androjava.helper.Message;

@Controller
@RequestMapping("/admin/adminpanel")
public class UsersQueryController {
	
	@Autowired
	private ServicesImple servicesImple;
	
	@RequestMapping("/UsersQuery/{pageNumber}")
	public String showUsersQueryList(@PathVariable("pageNumber")Integer pageNumber,Model model)
	{
	
			Pageable of = PageRequest.of(pageNumber, 10,Sort.by("id").descending());
			
			 Page<UserQuestions> questions = this.servicesImple.findAllUserQuestions(of);
			 
			 model.addAttribute("userQuestions", questions);
			 
			 model.addAttribute("currentpage",pageNumber);
			 model.addAttribute("totalPages", questions.getTotalPages());
		
		return "/admin/UserQueryList";
	}
	

	@RequestMapping(value="/deleteQuestion/{QuestionId}" ,method = RequestMethod.GET)
	private void deleteRootCategory(@PathVariable("QuestionId")Long QuestionId,Model model , HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		try {
			
			//get Course Category Single By Id
			this.servicesImple.deleteUserQuestion(QuestionId);
			
			 Message message=new Message("Question deleted", "alert-success");
			 session.setAttribute("message", message);  
			 response.sendRedirect("/admin/adminpanel/UsersQuery/0");
			 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
}

}
