package com.androjava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private String course;
	
	private String email;
	
	private String mobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ContactForm(Long id, String name, String lastName, String course, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.course = course;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ContactForm [id=" + id + ", name=" + name + ", lastName=" + lastName + ", course=" + course + ", email="
				+ email + ", mobile=" + mobile + "]";
	}

	public ContactForm(String name, String lastName, String course, String email, String mobile) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.course = course;
		this.email = email;
		this.mobile = mobile;
	}

	public ContactForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
