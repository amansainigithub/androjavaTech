package com.androjava.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CourseSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subcatId;
	
	private String subcatName;
	
	private String subcatTitle;
	
	@Column(length = 1000)
	private String subcatDescription;
	
	private String subcatKeyword;
	
	private String subcatUrl;
	
	private String subcatStatus;
	
	@Basic(optional = false)
	@Column( insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date subcatDate;
	
	
	private String subcatImageName;
	
	@ManyToOne
	private CourseCategoy courseCategoy;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "courseSubCategory")
	private List<CourseChapters> courseChapters;

	public int getSubcatId() {
		return subcatId;
	}

	public void setSubcatId(int subcatId) {
		this.subcatId = subcatId;
	}

	public String getSubcatName() {
		return subcatName;
	}

	public void setSubcatName(String subcatName) {
		this.subcatName = subcatName;
	}

	public String getSubcatTitle() {
		return subcatTitle;
	}

	public void setSubcatTitle(String subcatTitle) {
		this.subcatTitle = subcatTitle;
	}

	public String getSubcatDescription() {
		return subcatDescription;
	}

	public void setSubcatDescription(String subcatDescription) {
		this.subcatDescription = subcatDescription;
	}

	public String getSubcatKeyword() {
		return subcatKeyword;
	}

	public void setSubcatKeyword(String subcatKeyword) {
		this.subcatKeyword = subcatKeyword;
	}

	public String getSubcatUrl() {
		return subcatUrl;
	}

	public void setSubcatUrl(String subcatUrl) {
		this.subcatUrl = subcatUrl;
	}

	public String getSubcatStatus() {
		return subcatStatus;
	}

	public void setSubcatStatus(String subcatStatus) {
		this.subcatStatus = subcatStatus;
	}

	public Date getSubcatDate() {
		return subcatDate;
	}

	public void setSubcatDate(Date subcatDate) {
		this.subcatDate = subcatDate;
	}

	public String getSubcatImageName() {
		return subcatImageName;
	}

	public void setSubcatImageName(String subcatImageName) {
		this.subcatImageName = subcatImageName;
	}

	public CourseCategoy getCourseCategoy() {
		return courseCategoy;
	}

	public void setCourseCategoy(CourseCategoy courseCategoy) {
		this.courseCategoy = courseCategoy;
	}

	public List<CourseChapters> getCourseChapters() {
		return courseChapters;
	}

	public void setCourseChapters(List<CourseChapters> courseChapters) {
		this.courseChapters = courseChapters;
	}

	@Override
	public String toString() {
		return "CourseSubCategory [subcatId=" + subcatId + ", subcatName=" + subcatName + ", subcatTitle=" + subcatTitle
				+ ", subcatDescription=" + subcatDescription + ", subcatKeyword=" + subcatKeyword + ", subcatUrl="
				+ subcatUrl + ", subcatStatus=" + subcatStatus + ", subcatDate=" + subcatDate + ", subcatImageName="
				+ subcatImageName + ", courseCategoy=" + courseCategoy + ", courseChapters=" + courseChapters + "]";
	}

	public CourseSubCategory(int subcatId, String subcatName, String subcatTitle, String subcatDescription,
			String subcatKeyword, String subcatUrl, String subcatStatus, Date subcatDate, String subcatImageName,
			CourseCategoy courseCategoy, List<CourseChapters> courseChapters) {
		super();
		this.subcatId = subcatId;
		this.subcatName = subcatName;
		this.subcatTitle = subcatTitle;
		this.subcatDescription = subcatDescription;
		this.subcatKeyword = subcatKeyword;
		this.subcatUrl = subcatUrl;
		this.subcatStatus = subcatStatus;
		this.subcatDate = subcatDate;
		this.subcatImageName = subcatImageName;
		this.courseCategoy = courseCategoy;
		this.courseChapters = courseChapters;
	}

	public CourseSubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseSubCategory(String subcatName, String subcatTitle, String subcatDescription, String subcatKeyword,
			String subcatUrl, String subcatStatus, Date subcatDate, String subcatImageName, CourseCategoy courseCategoy,
			List<CourseChapters> courseChapters) {
		super();
		this.subcatName = subcatName;
		this.subcatTitle = subcatTitle;
		this.subcatDescription = subcatDescription;
		this.subcatKeyword = subcatKeyword;
		this.subcatUrl = subcatUrl;
		this.subcatStatus = subcatStatus;
		this.subcatDate = subcatDate;
		this.subcatImageName = subcatImageName;
		this.courseCategoy = courseCategoy;
		this.courseChapters = courseChapters;
	}
	
	
	
	
	

	
	
	
}
