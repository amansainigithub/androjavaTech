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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CourseCategoy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catId;
	
	private String categoryName;
	
	private String categoryTitle;
	
	@Column(length = 1000)
	private String categoryDescription;
	
	private String categoryKeyword;
	
	private String categoryUrl;
	
	//@Column(columnDefinition = "boolean default true")
	private String categoryStatus;
	
	@Basic(optional = false)
	@Column( insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date catDate;
	
	
	private String catImageName;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "courseCategoy")
	private List<CourseSubCategory> courseSubCategories;


	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryTitle() {
		return categoryTitle;
	}


	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}


	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}


	public String getCategoryKeyword() {
		return categoryKeyword;
	}


	public void setCategoryKeyword(String categoryKeyword) {
		this.categoryKeyword = categoryKeyword;
	}


	public String getCategory_url() {
		return categoryUrl;
	}


	public void setCategory_url(String category_url) {
		this.categoryUrl = category_url;
	}


	public String getCategoryStatus() {
		return categoryStatus;
	}


	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}


	public Date getCatDate() {
		return catDate;
	}


	public void setCatDate(Date catDate) {
		this.catDate = catDate;
	}


	public String getCatImageName() {
		return catImageName;
	}


	public void setCatImageName(String catImageName) {
		this.catImageName = catImageName;
	}


	public List<CourseSubCategory> getCourseSubCategories() {
		return courseSubCategories;
	}


	public void setCourseSubCategories(List<CourseSubCategory> courseSubCategories) {
		this.courseSubCategories = courseSubCategories;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catDate == null) ? 0 : catDate.hashCode());
		result = prime * result + catId;
		result = prime * result + ((catImageName == null) ? 0 : catImageName.hashCode());
		result = prime * result + ((categoryDescription == null) ? 0 : categoryDescription.hashCode());
		result = prime * result + ((categoryKeyword == null) ? 0 : categoryKeyword.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((categoryStatus == null) ? 0 : categoryStatus.hashCode());
		result = prime * result + ((categoryTitle == null) ? 0 : categoryTitle.hashCode());
		result = prime * result + ((categoryUrl == null) ? 0 : categoryUrl.hashCode());
		result = prime * result + ((courseSubCategories == null) ? 0 : courseSubCategories.hashCode());
		return result;
	}
	
	


	public String getCategoryUrl() {
		return categoryUrl;
	}


	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseCategoy other = (CourseCategoy) obj;
		if (catDate == null) {
			if (other.catDate != null)
				return false;
		} else if (!catDate.equals(other.catDate))
			return false;
		if (catId != other.catId)
			return false;
		if (catImageName == null) {
			if (other.catImageName != null)
				return false;
		} else if (!catImageName.equals(other.catImageName))
			return false;
		if (categoryDescription == null) {
			if (other.categoryDescription != null)
				return false;
		} else if (!categoryDescription.equals(other.categoryDescription))
			return false;
		if (categoryKeyword == null) {
			if (other.categoryKeyword != null)
				return false;
		} else if (!categoryKeyword.equals(other.categoryKeyword))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryStatus == null) {
			if (other.categoryStatus != null)
				return false;
		} else if (!categoryStatus.equals(other.categoryStatus))
			return false;
		if (categoryTitle == null) {
			if (other.categoryTitle != null)
				return false;
		} else if (!categoryTitle.equals(other.categoryTitle))
			return false;
		if (categoryUrl == null) {
			if (other.categoryUrl != null)
				return false;
		} else if (!categoryUrl.equals(other.categoryUrl))
			return false;
		if (courseSubCategories == null) {
			if (other.courseSubCategories != null)
				return false;
		} else if (!courseSubCategories.equals(other.courseSubCategories))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CourseCategoy [catId=" + catId + ", categoryName=" + categoryName + ", categoryTitle=" + categoryTitle
				+ ", categoryDescription=" + categoryDescription + ", categoryKeyword=" + categoryKeyword
				+ ", category_url=" + categoryUrl + ", categoryStatus=" + categoryStatus + ", catDate=" + catDate
				+ ", catImageName=" + catImageName + ", courseSubCategories=" + courseSubCategories + "]";
	}


	public CourseCategoy(int catId, String categoryName, String categoryTitle, String categoryDescription,
			String categoryKeyword, String category_url, String categoryStatus, Date catDate, String catImageName,
			List<CourseSubCategory> courseSubCategories) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.categoryKeyword = categoryKeyword;
		this.categoryUrl = category_url;
		this.categoryStatus = categoryStatus;
		this.catDate = catDate;
		this.catImageName = catImageName;
		this.courseSubCategories = courseSubCategories;
	}


	public CourseCategoy(String categoryName, String categoryTitle, String categoryDescription, String categoryKeyword,
			String category_url, String categoryStatus, Date catDate, String catImageName,
			List<CourseSubCategory> courseSubCategories) {
		super();
		this.categoryName = categoryName;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.categoryKeyword = categoryKeyword;
		this.categoryUrl = category_url;
		this.categoryStatus = categoryStatus;
		this.catDate = catDate;
		this.catImageName = catImageName;
		this.courseSubCategories = courseSubCategories;
	}


	public CourseCategoy() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
