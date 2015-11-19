package edu.mum.cs.cs544.project.care2share.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "POST_CONTENT", pkJoinColumns = @PrimaryKeyJoinColumn(name = "POST_ID") )
public class Post {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "SUB_TITLE")
	private String subTitle;
	@Lob
	@Column(name = "CONTENT", table = "POST_CONTENT")
	private String content;
	@ManyToOne
	@JoinColumn(name = "BLOGGER_ID")
	private Blogger blogger;
	@Column(name = "PUBLISHED_DATE")
	private Date publishedDate;

	public Post() {

	}

	public Post(String content, Blogger blogger, Date publishedDate) {
		this.content = content;
		this.blogger = blogger;
		this.publishedDate = publishedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

}
