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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseSubCategory;
import com.androjava.helper.DeleteImage;
import com.androjava.helper.Message;
import com.androjava.helper.SaveImage;

@Controller
@RequestMapping("/admin/adminpanel")
public class UpdateDelSubCategoryController {
	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private SaveImage saveImage;
	
	@RequestMapping("/getSubCatgoryList/{currentPage}")
	public String getCreateCategoryList(Model model,@PathVariable("currentPage")Integer currentPage)
	{
		model.addAttribute("title", "Course Category List");
		
		Pageable of = PageRequest.of(currentPage, 5,Sort.by("subcatId").descending());
		
		 Page<CourseSubCategory> subCategoryLists = this.servicesImple.findAllSubCategoryPageable(of);
		 model.addAttribute("subCategorylist",subCategoryLists);
		 
		 //current page
		 model.addAttribute("currentpage", currentPage);
		 
		 //total Pages
		 model.addAttribute("totalPages", subCategoryLists.getTotalPages());
		 
		 return "/admin/subCategoryList";
		 
	}
	
	@RequestMapping("/updateSubCategoryForm/{subCatid}")
	public String updateCourseCategoryForm(@PathVariable("subCatid")Integer subCatid,Model model)
	{
		System.out.println(subCatid);
		
		CourseSubCategory SubCategoryById = this.servicesImple.findSubCategoryById(subCatid);
		model.addAttribute("subCategory", SubCategoryById);
		
		return "/admin/updateSubCategoryForm";
	}
	
	
	@RequestMapping("/subCategoryUpdateNow")
	public String CourseCategoryUpdateNow(@ModelAttribute CourseSubCategory courseSubCategory,
											@RequestParam("subcatId")Integer subcatId,
											Model model ,@RequestParam("file") MultipartFile file ,
											HttpSession session)
	{
		try {
			
			 CourseSubCategory SubCategory = this.servicesImple.findSubCategoryById(subcatId);
				
				if(SubCategory != null)
				{
					SubCategory.setSubcatName(courseSubCategory.getSubcatName());
					SubCategory.setSubcatDescription(courseSubCategory.getSubcatDescription());
					SubCategory.setSubcatKeyword(courseSubCategory.getSubcatKeyword());
					SubCategory.setSubcatStatus(courseSubCategory.getSubcatStatus());
					SubCategory.setSubcatTitle(courseSubCategory.getSubcatTitle());
					SubCategory.setSubcatUrl(courseSubCategory.getSubcatUrl());
				}
				
				if(file.isEmpty())
				{
					 CourseSubCategory saveCourseSubCategory = this.servicesImple.saveCourseSubCategory(SubCategory);
					
					if(saveCourseSubCategory!=null)
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
					DeleteImage.deleteOldImage("subcategory_images", SubCategory.getSubcatImageName());
					
					SubCategory.setSubcatImageName(file.getOriginalFilename());
					
					//save image to directory
					boolean saveOrnot = this.saveImage.writingImage("subcategory_images", file);
					
					CourseSubCategory saveCourseSubCategory = this.servicesImple.saveCourseSubCategory(SubCategory);
					
					if(saveCourseSubCategory!=null)
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
		
		
		return "redirect:getSubCatgoryList/0";
	}
	
	
	
	
	@RequestMapping(value="/deleteSubCategory/{subCatId}" ,method = RequestMethod.GET)
	private void deleteRootCategory(@PathVariable("subCatId")Integer subCatId,Model model , HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		try {
			
			//get Course Category Single By Id
			CourseSubCategory subCategory= this.servicesImple.findSubCategoryById(subCatId);
			 
			boolean deleteOldImage = DeleteImage.deleteOldImage("subcategory_images", subCategory.getSubcatImageName());
			this.servicesImple.deleteSubCategoryById(subCatId);
			if(deleteOldImage==true)
			{
				
				 Message message=new Message("Category deleted", "alert-success");
				session.setAttribute("message", message);  
				response.sendRedirect("/admin/adminpanel/getSubCatgoryList/0");
				
			}
			else
			{
					Message message=new Message("Could Not deleted", "alert-danger");
					session.setAttribute("message", message); 
					response.sendRedirect("/admin/adminpanel/getSubCatgoryList/0");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			 Message message=new Message("Something went Wrong", "alert-danger");
			 session.setAttribute("message", message);  
			 response.sendRedirect("/admin/adminpanel/getSubCatgoryList/0");
			
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
