package com.androjava.admin.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.androjava.helper.Message;
import com.androjava.helper.Navbar_SubCategory_Reader;

@Controller
@RequestMapping("/admin/adminpanel")
public class NavbarReader {
	
	@RequestMapping("/navbarWriterForm")
	public String navbar_Witer_Form(Model model)
	{
		
		try {
			
			ClassPathResource classPathResource = new ClassPathResource("/static/files/NavbarCounter-SubCategory.txt");
	        InputStream inputStream = classPathResource.getInputStream();
	        
	        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
           String data = new String(bdata, StandardCharsets.UTF_8);
			
           model.addAttribute("data", data);
		inputStream.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("title", "navbar Writer Form");
		return "/admin/navbarWriterForm";
		
	}
	
	
	//Change Nav-bar value
	@RequestMapping(value="/changeNavbarValue",method = RequestMethod.POST)
	public String changeNavbarValue(@RequestParam("navbarValue")String navbarValue,HttpSession session) throws IOException
	{
		//Number Checker
		boolean onlyDigits = Navbar_SubCategory_Reader.onlyDigits(navbarValue, navbarValue.length());
		
		if(onlyDigits==false)
		{
			Message message=new Message("please Enter a Digit", "alert-danger");
			session.setAttribute("message", message);
			
			return "redirect:navbarWriterForm";
		}
		
		
		File file = new ClassPathResource("/static/files/NavbarCounter-SubCategory.txt").getFile();
		
		System.out.println(file.getName());
		FileWriter fileWriter=new FileWriter(file);
		fileWriter.write(navbarValue);
		
		fileWriter.close();
		
		Message message=new Message("Data Updated", "alert-success");
		session.setAttribute("message", message);
		
		return "redirect:navbarWriterForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
