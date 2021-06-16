package com.androjava.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String adminName;
	
	
	private String adminEmail;
	
	private String adminPassword;
	
	private String adminMobile;
	
	@Column(columnDefinition = "boolean default false")
	private boolean adminStatus;
	
	@Basic(optional = false)
	@Column( insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date adminDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public boolean isAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Date getAdminDate() {
		return adminDate;
	}

	public void setAdminDate(Date adminDate) {
		this.adminDate = adminDate;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", adminPassword="
				+ adminPassword + ", adminMobile=" + adminMobile + ", adminStatus=" + adminStatus + ", adminDate="
				+ adminDate + "]";
	}

	public Admin(String adminName, String adminEmail, String adminPassword, String adminMobile, boolean adminStatus,
			Date adminDate) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminMobile = adminMobile;
		this.adminStatus = adminStatus;
		this.adminDate = adminDate;
	}

	public Admin(int id, String adminName, String adminEmail, String adminPassword, String adminMobile,
			boolean adminStatus, Date adminDate) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminMobile = adminMobile;
		this.adminStatus = adminStatus;
		this.adminDate = adminDate;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


}
