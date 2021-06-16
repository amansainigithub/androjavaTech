package com.androjava.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.androjava.admin.services.ServicesImple;
import com.androjava.entity.CourseCategoy;

@Component
public class NavbarHelper {
	
	@Autowired
	private ServicesImple servicesImple;
	
	
	public List<CourseCategoy> getNavbarData()
	{
		return  this.servicesImple.findAllCourseCategory();
	}

}
