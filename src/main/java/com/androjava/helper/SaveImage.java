package com.androjava.helper;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SaveImage {
	
	public boolean writingImage(String foldername,MultipartFile file)
	{
		try {
			//getting the Real Path of the Directory
			String absolutePath = new ClassPathResource("/static/"+foldername+"/").getFile().getPath();
			
			//Writing the Image
			byte[] bytes =file.getBytes();
			FileOutputStream fileOutputStream=new FileOutputStream(absolutePath+File.separator+file.getOriginalFilename());
			fileOutputStream.write(bytes);
			fileOutputStream.close();
			
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	

}
