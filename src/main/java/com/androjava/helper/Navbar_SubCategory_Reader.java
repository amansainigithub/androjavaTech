package com.androjava.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class Navbar_SubCategory_Reader {
	
	
	public int navbarSubCategoryReader()
	{
		String data="";
		
		try {
			//String path = new ClassPathResource("/static/files/").getFile().getPath();
			
				ClassPathResource classPathResource = new ClassPathResource("/static/files/NavbarCounter-SubCategory.txt");
		        InputStream inputStream = classPathResource.getInputStream();
		        
		        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
	           data = new String(bdata, StandardCharsets.UTF_8);
	            
			
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		
		return Integer.parseInt(data);
	}
	
	
	
	
	//only check number
	 public static boolean
	    onlyDigits(String str, int n)
	    {
	        // Traverse the string from
	        // start to end
	        for (int i = 0; i < n; i++) {
	  
	            // Check if character is
	            // digit from 0-9
	            // then return true
	            // else false
	            if (str.charAt(i) >= '0'
	                && str.charAt(i) <= '9') {
	                return true;
	            }
	            else {
	                return false;
	            }
	        }
	        return false;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
