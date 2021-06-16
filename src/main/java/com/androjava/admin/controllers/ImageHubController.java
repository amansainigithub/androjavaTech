package com.androjava.admin.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.ImageHub;
import com.androjava.helper.Message;

@Controller
@RequestMapping("/admin/adminpanel")
public class ImageHubController {
	
	@Autowired
	private ServicesImple servicesImple;
	
	//LOCAL-SERVER URL
	//private String URL="http://localhost:8081/imagesHub/";
	
	//LIVE-SERVER
	private String URL="https://www.androjavatech4u.com/imagesHub/";
	
	@RequestMapping("/imageHub")
	public String imageHubPage(Model model)
	{
		model.addAttribute("title", "AndrojavaTech4u ImageHub");
		return "/admin/imageHub";
	}
	
	@RequestMapping("/getImageHubUploadForm")
	public String showImageHub_UploadForm(Model model)
	{
		model.addAttribute("title", "AndrojavaTech4u ImageHub");
		return "/admin/uploadFormImgHub";
	}
	
	
	@RequestMapping("/uploadHubImages")
	public String uploadHubImages(@ModelAttribute ImageHub imageHub,HttpSession session,Model model)
	{
		
		//set USEREMAIL
		String userEmail=(String)session.getAttribute("ad_Email");
		
		List<MultipartFile> images = imageHub.getImages();
		
		//getting the Real Path of the Directory
		try {
			String absolutePath = new ClassPathResource("/static/imagesHub/").getFile().getPath();
			
		
		for(MultipartFile mul : images)
		{
			//Writing the Image
			byte[] bytes =mul.getBytes();
			FileOutputStream fileOutputStream=new FileOutputStream(absolutePath+File.separator+mul.getOriginalFilename());
			fileOutputStream.write(bytes);
			fileOutputStream.close();
			
			
			
			
			//LIVE SERVER
			//imageHub.setImageUrl(URL+absolutePath+mul.getOriginalFilename());
			
			//Setting Data to image hub single Object
			ImageHub hub=new ImageHub();
			hub.setImageNames(imageHub.getImageNames());
			
			
			//LIVE-SERVER OR LOCAL_SERVER URL first remove-comment to upper side
			hub.setImageUrl(URL+mul.getOriginalFilename());
			
			hub.setUserEmail(userEmail);
			
			//SAVE IMAGE TO DATABASE
			this.servicesImple.saveImageToImageHub(hub);
		}
		
		Message message=new Message("Data Successfully added", "alert-success");
		session.setAttribute("message", message);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Message message=new Message("Something went wrong", "alert-danger");
			session.setAttribute("message", message);
			
		}
		
		
		return "redirect:getImageHubUploadForm";
	}
	
	
	
	
	//getImages HUB IMAGES
	@RequestMapping("/getImageHubImages")
	public String getImageHub_Images(Model model)
	{
		model.addAttribute("title", "ImageHub Images");
		
		List<ImageHub> findTop10ImagesinImageHub = this.servicesImple.findTop10ImagesinImageHub();
		
		model.addAttribute("totalImages", findTop10ImagesinImageHub.size());
		
		model.addAttribute("hubImages",findTop10ImagesinImageHub);
		
		return "/admin/getImageHubImages";
	}
	
	@RequestMapping(value ="searchImagesToImageHub",method = RequestMethod.POST)
	public String SearchImagesTo_ImageHub(@RequestParam("imageName")String imageName,
														Model model,
														HttpSession session)
	{
		try {
			
			model.addAttribute("title", imageName);
			
			List<ImageHub> searchingImages = this.servicesImple.findByImagesViaSearching(imageName);
			
			if(searchingImages.isEmpty() )
			{
				Message message=new Message(" <div >\r\n"
						+ "   			\r\n"
						+ "   			<div class=\"container text-center\">\r\n"
						+ "   			 \r\n"
						+ "   				<img src=\"/adminDashboard_images/not-found.jpg\" alt=\"Oops Image Not found\" height=\"400\" width=\"600\"  />\r\n"
						+ "   			\r\n"
						+ "   			\r\n"
						+ "   			</div>\r\n"
						+ "   			\r\n"
						+ "    </div>", "alert-warning");
				session.setAttribute("message", message);
				return "/admin/getImageHubImages";
			}
			else
			{
				
				model.addAttribute("totalImages", searchingImages.size());
				model.addAttribute("searchImages", searchingImages);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
		
		return "/admin/getImageHubImages";
	}
	
	
	
	
	
	
	

}
