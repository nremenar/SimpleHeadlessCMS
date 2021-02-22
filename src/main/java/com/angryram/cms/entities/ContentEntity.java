package com.angryram.cms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
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
	
	
}
