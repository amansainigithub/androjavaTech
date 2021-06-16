package com.androjava.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ImageHub {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userEmail;
	
	@Column(length = 1000)
	private String imageNames;
	
	@Column(length = 1000)
	private String imageUrl;
	
	@Transient
	private List<MultipartFile> images;
	
	@Basic(optional = false)
	@Column( insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date imgDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getImageNames() {
		return imageNames;
	}

	public void setImageNames(String imageNames) {
		this.imageNames = imageNames;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public Date getImgDate() {
		return imgDate;
	}

	public void setImgDate(Date imgDate) {
		this.imgDate = imgDate;
	}

	@Override
	public String toString() {
		return "ImageHub [id=" + id + ", userEmail=" + userEmail + ", imageNames=" + imageNames + ", imageUrl="
				+ imageUrl + ", images=" + images + ", imgDate=" + imgDate + "]";
	}

	public ImageHub(Long id, String userEmail, String imageNames, List<MultipartFile> images, Date imgDate) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.imageNames = imageNames;
		this.images = images;
		this.imgDate = imgDate;
	}

	public ImageHub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ImageHub(Long id, String userEmail, String imageNames, String imageUrl, List<MultipartFile> images,
			Date imgDate) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.imageNames = imageNames;
		this.imageUrl = imageUrl;
		this.images = images;
		this.imgDate = imgDate;
	}

	public ImageHub(String userEmail, String imageNames, String imageUrl, List<MultipartFile> images, Date imgDate) {
		super();
		this.userEmail = userEmail;
		this.imageNames = imageNames;
		this.imageUrl = imageUrl;
		this.images = images;
		this.imgDate = imgDate;
	}
	
	
	

}
