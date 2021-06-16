package com.androjava.home.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.ContactForm;
import com.androjava.helper.SendEmail;

@Controller
public class ContactFormController {
	
	@Autowired
	private ServicesImple servicesImple;
	
	@RequestMapping(value="/contactForm",method = RequestMethod.POST)
	public String SubmitContactForm(@ModelAttribute ContactForm contactForm ) throws InterruptedException
	{
		
		this.servicesImple.saveContactFormData(contactForm);
		try {
			SendEmail.sendEmail(contactForm, "amansaini1407@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:contact";
	}

}
