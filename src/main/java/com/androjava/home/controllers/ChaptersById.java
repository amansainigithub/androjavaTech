package com.androjava.home.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;
import com.androjava.entity.CourseChapters;
import com.androjava.entity.CourseSubCategory;
import com.androjava.entity.ManageUrl;
import com.androjava.helper.NavbarHelper;
import com.androjava.helper.Navbar_SubCategory_Reader;

@Controller
public class ChaptersById {
	
	@Autowired
	private NavbarHelper navbarHelper;
	
	@Autowired
	private ServicesImple servicesImple;
	
	@Autowired
	private Navbar_SubCategory_Reader navbar_SubCategory_Reader;
	
	
	@RequestMapping("/{category-url}/chapter/{categoryId}")
	public String findByCategoryURL(@PathVariable("category-url")String chapterUrl,
									@PathVariable("categoryId")Integer categoryId, Model model)
	{
		
			
			CourseCategoy course = this.servicesImple.findByCourseId(categoryId);
			
			List<CourseChapters> allChapters = this.servicesImple.findAllChaptresByCategoryId(String.valueOf(categoryId).trim());
			
			if(allChapters.isEmpty())
			{
				//Fetch Header
				model.addAttribute("courseCategory", navbarHelper.getNavbarData());
				
				return "/page404";
			}
			
			
			CourseChapters chapter = allChapters.get(0);
			
			
			//get SubCategory Hading
			model.addAttribute("courseName", course.getCategoryName());
			
			//Set single Chapter
			model.addAttribute("singleChapter",chapter);
			
			model.addAttribute("courseCategory", course);
			//Set Title
			model.addAttribute("title", chapter.getChapterName());
			
			
			//model.addAttribute("course", course);//changes
			
			
			System.out.println("*******************************************************");
			
			
			
			CourseSubCategory subcategory = this.servicesImple.findyBySubCategoryUrl(chapter.getCourseSubCategory().getSubcatUrl());
			List<CourseChapters> courseChapters = subcategory.getCourseChapters();
			//System.out.println(courseChapters.size());
			try {
				CourseChapters staticChapter = courseChapters.get(1);
				
				model.addAttribute("nextUrl", staticChapter.getChapterUrl()+"/sc/"+staticChapter.getCourseSubCategory().getCourseCategoy().getCatId());
			} catch (Exception e) {
				
				try {
					
					CourseChapters all = allChapters.get(1);
					
					CourseSubCategory subcategory12 = this.servicesImple.findyBySubCategoryUrl(all.getCourseSubCategory().getSubcatUrl());
					List<CourseChapters> courseChapters12 = subcategory12.getCourseChapters();
					CourseChapters staticChapter111 = courseChapters12.get(0);
					model.addAttribute("nextUrl", staticChapter111.getChapterUrl()+"/sc/"+staticChapter111.getCourseSubCategory().getCourseCategoy().getCatId());
					
					
					
				} catch (Exception e2) {
					model.addAttribute("nextUrl", null);
					e.printStackTrace();
				}
				
				
				
				
			}
			
			System.out.println("##############--NAVBAR HADING WITH LIST--#################");
			
			int navbarSubCategoryReader = this.navbar_SubCategory_Reader.navbarSubCategoryReader();
			
			if(navbarSubCategoryReader == 0)
			{
				navbarSubCategoryReader=8;
			}
			
			ArrayList<ManageUrl> urls=new ArrayList<ManageUrl>();
			
			List<CourseSubCategory> courseSubCategories = course.getCourseSubCategories();
			
			int i=0;
			for(CourseSubCategory sub : courseSubCategories)
			{
				i++;
				if(i==navbarSubCategoryReader)
				{
					break;
				}
				System.out.println(sub.getCourseChapters().get(0).getChapterUrl()+"/sc/"+course.getCatId());
				urls.add( new ManageUrl(sub.getCourseChapters().get(0).getChapterUrl()+"/sc/"+course.getCatId(),sub.getSubcatName()));
				
			}
			model.addAttribute("course", urls);
			
			System.out.println("******************SUBCAT NAME ********************");
			
			model.addAttribute("subcatName", chapter.getCourseSubCategory().getSubcatName());
			
		return "showChapters";
	}
	
	
	
	
	
	
	//Second Request
	
	@RequestMapping("/{chapter-url}/sc/{courseId}")
	public String findByChapterUrl(@PathVariable("chapter-url")String chapterUrl,@PathVariable("courseId")Integer courseId ,Model model)
		{
		 CourseCategoy course=null;
		try {
		
			CourseChapters chapter = this.servicesImple.findByChapterUrlName(chapterUrl);
			
			course= this.servicesImple.findByCourseId(courseId);
			
			System.out.println("////////SUBCAT NAME/////////");
			
			model.addAttribute("subcatName", chapter.getCourseSubCategory().getSubcatName());
			
			
			
		//get SubCategory Hading
		model.addAttribute("courseName", course.getCategoryName());
			
		//Set single Chapter
		model.addAttribute("singleChapter",chapter);
		
		model.addAttribute("courseCategory", course);//changes
		//Set Title
		model.addAttribute("title", chapter.getChapterName());
	
		
		//MANAGE NEXT AND PREVIOUS URLS
		ArrayList<ManageUrl> urlList=new ArrayList<ManageUrl>();
		for(CourseSubCategory csc : course.getCourseSubCategories())
		{
			
			List<CourseChapters> courseChapters = csc.getCourseChapters();
			
			
			for(CourseChapters chap : courseChapters)
			{
				urlList.add(new ManageUrl( chap.getChapterUrl()+"/sc/"+csc.getCourseCategoy().getCatId()));
			}
			
		}
		
		int i=0,counter=0;
		for(ManageUrl url : urlList)
		{
			if(i==1)
			{
				
				model.addAttribute("nextUrl", url.getUrl());
				break;
			}
			counter++;
			if(url.getUrl().trim().equals(chapterUrl+"/sc/"+courseId))
			{
				i++;
			}
		}
		counter=counter-2;
		ManageUrl previous = urlList.get(counter);
		model.addAttribute("previous", previous.getUrl());

		
		
		
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		System.out.println("##############--NAVBAR HADING WITH LIST--#################");
		
		int navbarSubCategoryReader = this.navbar_SubCategory_Reader.navbarSubCategoryReader();
		
		if(navbarSubCategoryReader == 0)
		{
			navbarSubCategoryReader=8;
		}
		
		ArrayList<ManageUrl> urls=new ArrayList<ManageUrl>();
		
		List<CourseSubCategory> courseSubCategories = course.getCourseSubCategories();
		
		int i=0;
		
		for(CourseSubCategory sub : courseSubCategories)
		{
			i++;
			if(i==navbarSubCategoryReader)
			{
				break;
			}
			System.out.println(sub.getCourseChapters().get(0).getChapterUrl()+"/sc/"+course.getCatId());
			urls.add( new ManageUrl(sub.getCourseChapters().get(0).getChapterUrl()+"/sc/"+course.getCatId(),sub.getSubcatName()));
			
		}
		model.addAttribute("course", urls);
		
		
		
		
		return "showChapters";
		}
			
			
			
	
	
}
