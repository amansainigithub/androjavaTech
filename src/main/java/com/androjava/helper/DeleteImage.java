package com.androjava.helper;

import java.io.File;

import org.springframework.core.io.ClassPathResource;

public class DeleteImage {
	
	public static boolean deleteOldImage(String folderName,String deleteImageName)
	{
		
		boolean flag=false;
		
		try {
			//getting the Real Path of the Directory
			String path = new ClassPathResource("/static/"+folderName+"/").getFile().getPath();
			System.out.println(path);
			File file=new File(path+File.separator+deleteImageName);
			flag=file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
