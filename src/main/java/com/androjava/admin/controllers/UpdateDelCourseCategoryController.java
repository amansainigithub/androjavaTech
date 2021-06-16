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
import com.androjava.helper.DeleteImage;
import com.androjava.helper.Message;
import com.androjava.helper.SaveImage;

@Controller
@RequestMapping("/admin/adminpanel")
public class UpdateDelCourseCategoryController {
	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private SaveImage saveImage;
	
	@RequestMapping("/getCourseCatgoryList/{pageNumber}")
	public String getCreateCategoryList(Model model,@PathVariable("pageNumber")Integer pageNumber)
	{
		model.addAttribute("title", "Course Category List");
		
		Pageable of = PageRequest.of(pageNumber, 10,Sort.by("catId").descending());
		
		 Page<CourseCategoy> courseCategoryList = this.servicesImple.findAllCourseCategoryPageable(of);
		 model.addAttribute("courseCategorylist", courseCategoryList);
		 model.addAttribute("currentpage", pageNumber);
		 model.addAttribute("totalPages", courseCategoryList.getTotalPages());
		 return "/admin/courseCategoryList";
		 
		
	}
	
	@RequestMapping("/updateCourseCategoryForm/{catid}")
	public String updateCourseCategoryForm(@PathVariable("catid")Integer catid,Model model)
	{
		System.out.println(catid);
		
		CourseCategoy course = this.servicesImple.findByCourseId(catid);
		model.addAttribute("course", course);
		
		return "/admin/updateCourseCategoryForm";
	}
	
	
	@RequestMapping("/CourseCategoryUpdateNow")
	public String CourseCategoryUpdateNow(@ModelAttribute CourseCategoy courseCategoy,
											@RequestParam("categoryId")Integer categoryId,
											Model model ,@RequestParam("file") MultipartFile file ,
											HttpSession session)
	{
		try {
			
			CourseCategoy course = this.servicesImple.findByCourseId(categoryId);
				
				if(course != null)
				{
					course.setCategoryName(courseCategoy.getCategoryName());
					course.setCategoryDescription(courseCategoy.getCategoryDescription());
					course.setCategoryKeyword(courseCategoy.getCategoryKeyword());
					course.setCategoryStatus(courseCategoy.getCategoryStatus());
					course.setCategoryTitle(courseCategoy.getCategoryTitle());
					course.setCategoryUrl(courseCategoy.getCategory_url());
				}
				
				if(file.isEmpty())
				{
					CourseCategoy saveCourseCategory = this.servicesImple.saveCourseCategory(course);
					
					if(saveCourseCategory!=null)
					{
						Message message=new Message("update success", "alert-success");
						session.setAttribute("message", message);
					}
					else
					{
						throw new Exception("update Failed");
					}
				}
				else
				{
					//delete old image
					DeleteImage.deleteOldImage("categoryImages", course.getCatImageName());
					
					course.setCatImageName(file.getOriginalFilename());
					
					//save image to directory
					boolean saveOrnot = this.saveImage.writingImage("categoryImages", file);
					
					CourseCategoy saveCourseCategory = this.servicesImple.saveCourseCategory(course);
					
					if(saveCourseCategory!=null)
					{
						Message message=new Message("update success", "alert-success");
						session.setAttribute("message", message);
					}
					else
					{
						throw new Exception("update Failed");
					}
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Message message=new Message("update success", e.getMessage());
			session.setAttribute("message", message);
		}
		
		
		return "redirect:getCourseCatgoryList/0";
	}
	
	
	@RequestMapping(value="/deleteCourseCategory/{courseId}" ,method = RequestMethod.GET)
	private void deleteRootCategory(@PathVariable("courseId")Integer courseId,Model model , HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		try {
			
			//get Course Category Single By Id
			CourseCategoy course= this.servicesImple.findByCourseId(courseId);
			 
			boolean deleteOldImage = DeleteImage.deleteOldImage("categoryImages", course.getCatImageName());
			this.servicesImple.deleteByCourseId(courseId);
			if(deleteOldImage==true)
			{
				
				 Message message=new Message("Category deleted", "alert-success");
				session.setAttribute("message", message);  
				response.sendRedirect("/admin/adminpanel/getCourseCatgoryList/0");
				
			}
			else
			{
					Message message=new Message("Could Not deleted", "alert-danger");
					session.setAttribute("message", message); 
					response.sendRedirect("/admin/adminpanel/getCourseCatgoryList/0");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			 Message message=new Message("Something went Wrong", "alert-danger");
			 session.setAttribute("message", message);  
			 response.sendRedirect("/admin/adminpanel/getCourseCatgoryList/0");
			
		}
}
	
	
	
	
	
	
}
