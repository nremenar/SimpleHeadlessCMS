package com.angryram.cms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Builder
@Table(name="content")
public class ContentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	private Integer articleid;
	@Getter @Setter
	private String text;
	@Getter @Setter 
	private Integer langid;
	@Getter @Setter 
	private String subtitle;
	@Getter @Setter 
	private String title;


	public ContentEntity() {}
	public ContentEntity(Integer id, Integer articleid, String text, Integer langid, String subtitle, String title) {
		this.id = id;
		this.articleid = articleid;
		this.text = text;
		this.langid = langid;
		this.subtitle = subtitle;
		this.title = title;
	}
}
