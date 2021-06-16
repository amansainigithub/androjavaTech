package com.androjava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserQuestions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String question;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "UserQuestions [id=" + id + ", name=" + name + ", email=" + email + ", question=" + question + "]";
	}

	public UserQuestions(Long id, String name, String email, String question) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.question = question;
	}

	public UserQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserQuestions(String name, String email, String question) {
		super();
		this.name = name;
		this.email = email;
		this.question = question;
	}

	
	
	
	

}
