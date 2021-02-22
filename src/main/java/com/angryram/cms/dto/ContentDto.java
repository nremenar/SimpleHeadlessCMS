package com.angryram.cms.dto;

public class ContentDto {
	private Integer id;
	private Integer articleid;
	private String text;
	private String langid;
	private String title;
	private String subtitle;
	
	
	public ContentDto() {};
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLangid() {
		return langid;
	}
	public void setLangid(String langid) {
		this.langid = langid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	
	
	
}
