package com.androjava.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CourseChapters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long chapterId;
	
	private String chapterName;
	
	@Column(length = 2000)
	private String chapterTitle;
	
	@Column(length = 2000)
	private String chapterSubTitle;
	
	@Column(length = 2000)
	private String chapterDescription;
	
	@Type(type="text")
	private String chapterContent;
	
	@Column(length = 500)
	private String chapterKeywords;
	
	private String chapterUrl;
	
	
	private String chapterStatus;
	
	@Basic(optional = false)
	@Column( insertable = false, updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date chapterDate;
	
	private String chapterImageName;
	
	
	private String categoryId;
	
	private String sub_CategoryId;
	
	@ManyToOne
	private CourseSubCategory courseSubCategory;

	public CourseChapters() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseChapters(String chapterName, String chapterTitle, String chapterSubTitle, String chapterDescription,
			String chapterContent, String chapterKeywords, String chapterUrl, String chapterStatus, Date chapterDate,
			String chapterImageName, String categoryId, String sub_CategoryId, CourseSubCategory courseSubCategory) {
		super();
		this.chapterName = chapterName;
		this.chapterTitle = chapterTitle;
		this.chapterSubTitle = chapterSubTitle;
		this.chapterDescription = chapterDescription;
		this.chapterContent = chapterContent;
		this.chapterKeywords = chapterKeywords;
		this.chapterUrl = chapterUrl;
		this.chapterStatus = chapterStatus;
		this.chapterDate = chapterDate;
		this.chapterImageName = chapterImageName;
		this.categoryId = categoryId;
		this.sub_CategoryId = sub_CategoryId;
		this.courseSubCategory = courseSubCategory;
	}

	public CourseChapters(Long chapterId, String chapterName, String chapterTitle, String chapterSubTitle,
			String chapterDescription, String chapterContent, String chapterKeywords, String chapterUrl,
			String chapterStatus, Date chapterDate, String chapterImageName, String categoryId, String sub_CategoryId,
			CourseSubCategory courseSubCategory) {
		super();
		this.chapterId = chapterId;
		this.chapterName = chapterName;
		this.chapterTitle = chapterTitle;
		this.chapterSubTitle = chapterSubTitle;
		this.chapterDescription = chapterDescription;
		this.chapterContent = chapterContent;
		this.chapterKeywords = chapterKeywords;
		this.chapterUrl = chapterUrl;
		this.chapterStatus = chapterStatus;
		this.chapterDate = chapterDate;
		this.chapterImageName = chapterImageName;
		this.categoryId = categoryId;
		this.sub_CategoryId = sub_CategoryId;
		this.courseSubCategory = courseSubCategory;
	}

	@Override
	public String toString() {
		return "CourseChapters [chapterId=" + chapterId + ", chapterName=" + chapterName + ", chapterTitle="
				+ chapterTitle + ", chapterSubTitle=" + chapterSubTitle + ", chapterDescription=" + chapterDescription
				+ ", chapterContent=" + chapterContent + ", chapterKeywords=" + chapterKeywords + ", chapterUrl="
				+ chapterUrl + ", chapterStatus=" + chapterStatus + ", chapterDate=" + chapterDate
				+ ", chapterImageName=" + chapterImageName + ", categoryId=" + categoryId + ", sub_CategoryId="
				+ sub_CategoryId + ", courseSubCategory=" + courseSubCategory + "]";
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public String getChapterSubTitle() {
		return chapterSubTitle;
	}

	public void setChapterSubTitle(String chapterSubTitle) {
		this.chapterSubTitle = chapterSubTitle;
	}

	public String getChapterDescription() {
		return chapterDescription;
	}

	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}

	public String getChapterContent() {
		return chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	public String getChapterKeywords() {
		return chapterKeywords;
	}

	public void setChapterKeywords(String chapterKeywords) {
		this.chapterKeywords = chapterKeywords;
	}

	public String getChapterUrl() {
		return chapterUrl;
	}

	public void setChapterUrl(String chapterUrl) {
		this.chapterUrl = chapterUrl;
	}

	public String getChapterStatus() {
		return chapterStatus;
	}

	public void setChapterStatus(String chapterStatus) {
		this.chapterStatus = chapterStatus;
	}

	public Date getChapterDate() {
		return chapterDate;
	}

	public void setChapterDate(Date chapterDate) {
		this.chapterDate = chapterDate;
	}

	public String getChapterImageName() {
		return chapterImageName;
	}

	public void setChapterImageName(String chapterImageName) {
		this.chapterImageName = chapterImageName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSub_CategoryId() {
		return sub_CategoryId;
	}

	public void setSub_CategoryId(String sub_CategoryId) {
		this.sub_CategoryId = sub_CategoryId;
	}

	public CourseSubCategory getCourseSubCategory() {
		return courseSubCategory;
	}

	public void setCourseSubCategory(CourseSubCategory courseSubCategory) {
		this.courseSubCategory = courseSubCategory;
	}

	
	
	
	
	
	
	
	
	
	
	

}
