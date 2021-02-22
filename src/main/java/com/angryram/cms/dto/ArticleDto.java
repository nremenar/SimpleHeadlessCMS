package com.angryram.cms.dto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.angryram.cms.entities.AuthorEntity;

public class ArticleDto {
	private Integer id;
	private Integer authorid;
	private Integer categoryid;
	private Integer mainimgid;
	private Date created;
	private Date publishdate;
	
	private List<ContentDto> contents;
	
	private Optional<AuthorEntity> author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getMainimgid() {
		return mainimgid;
	}

	public void setMainimgid(Integer mainimgid) {
		this.mainimgid = mainimgid;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public List<ContentDto> getContents() {
		return contents;
	}

	public void setContents(List<ContentDto> contents) {
		this.contents = contents;
	}

	public Optional<AuthorEntity> getAuthor() {
		return author;
	}

	public void setAuthor(Optional<AuthorEntity> optional) {
		this.author = optional;
	}
	
	
	
}
