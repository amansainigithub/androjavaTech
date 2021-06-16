package com.androjava.entity;

public class ManageUrl {
	
	private String url;
	
	private String name;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ManageUrl(String url) {
		super();
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManageUrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManageUrl(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	
	
	
	

}
