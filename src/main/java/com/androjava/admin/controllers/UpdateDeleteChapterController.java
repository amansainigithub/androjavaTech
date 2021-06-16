package com.androjava.admin.controllers;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.helper.DeleteImage;
import com.androjava.helper.Message;

@Controller
@RequestMapping("/admin/adminpanel")
public class UpdateDeleteChapterController {
	
	@Autowired
	private ServicesImple servicesImple;
	
	
	@RequestMapping("/getChapterList/{pageNumber}")
	public String getCreateCategoryList(Model model,@PathVariable("pageNumber")Integer pageNumber)
	{
		model.addAttribute("title", "Course Category List");
		
		Pageable of = PageRequest.of(pageNumber, 10,Sort.by("chapterId").descending());
		
		Page<CourseChapters> chapterList = this.servicesImple.findAllChaptersPagenation(of);
		
		//Chapter List
		 model.addAttribute("courseCategorylist", chapterList);
		 
		 //current Page
		 model.addAttribute("currentpage", pageNumber);
		 
		 //Total Pages
		 model.addAttribute("totalPages", chapterList.getTotalPages());
		 
		 return "/admin/chapterList";
		 
		
	}
	
	@RequestMapping("/updateChapterForm/{chapterId}")
	public String updateCourseCategoryForm(@PathVariable("chapterId")Long chapterId,Model model)
	{
		
		CourseChapters chapter = this.servicesImple.findByChapterId(chapterId);
		model.addAttribute("chapter", chapter);
		
		return "/admin/updateDeleteChapterForm";
	}
	
	@RequestMapping("/chapterUpdateNow")
	public String CourseCategoryUpdateNow(@ModelAttribute CourseChapters courseChapters ,
											@RequestParam("chapterId")Long chapterId,
											Model model ,
											HttpSession session)
	{
		try {
			
			CourseChapters chapter = this.servicesImple.findByChapterId(chapterId);
				
				if(chapter != null)
				{
					chapter.setChapterName(courseChapters.getChapterName());
					chapter.setChapterTitle(courseChapters.getChapterTitle());
					chapter.setChapterSubTitle(courseChapters.getChapterSubTitle());
					chapter.setChapterDescription(courseChapters.getChapterDescription());
					chapter.setChapterContent(courseChapters.getChapterContent());
					chapter.setChapterKeywords(courseChapters.getChapterKeywords());
					chapter.setChapterUrl(courseChapters.getChapterUrl());
					chapter.setChapterStatus(courseChapters.getChapterStatus());
					
					this.servicesImple.saveCourseChapter(chapter);
					
					Message message=new Message("update success", "alert-success");
					session.setAttribute("message", message);
					
				}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Message message=new Message("update Failed","alert-danger");
			session.setAttribute("message", message);
		}
		
		
		return "redirect:getChapterList/0";
	}
	
	
	
	
	
	
	
	//DELETE
	@RequestMapping(value="/deleteChapter/{chapterId}" ,method = RequestMethod.GET)
	private void deleteRootCategory(@PathVariable("chapterId")Long chapterId,
													Model model , 
													HttpServletRequest request,
													HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		try {
			
			//get Course Category Single By Id
			this.servicesImple.deleteChapterById(chapterId);
				
				//Set message to session
				Message message=new Message("Chapter deleted", "alert-success");
				session.setAttribute("message", message);  
				response.sendRedirect("/admin/adminpanel/getChapterList/0");
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//Set message to session
			 Message message=new Message("Something went Wrong", "alert-danger");
			 session.setAttribute("message", message);  
			 response.sendRedirect("/admin/adminpanel/getChapterList/0");
			
		}
	
	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
