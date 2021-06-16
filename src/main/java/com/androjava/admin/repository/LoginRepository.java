package com.androjava.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.androjava.entity.Admin;

public interface LoginRepository extends JpaRepository<Admin, Integer> {
	
	public  Admin findByadminNameAndAdminPassword(String name,String password);

}
