package com.angryram.cms.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name="articles")
public class ArticleEntity implements Serializable{

	private static final long serialVersionUID = -4087970586697604468L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter @Setter
	private Integer authorid;
	
	@Getter 
	@Setter
	private Integer categoryid;
	@Getter @Setter
	private Integer mainimgid;
	@Getter @Setter
	private Date created;
	@Getter @Setter
	private Date publishdate;
	@Getter @Setter
	private Integer langid;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", insertable = false, updatable = false)
	private AuthorEntity author;
    
    @Getter @Setter
    private String title;
    @Getter @Setter 
    private String subtitle;
    @Getter @Setter
    private String text;
    

}
