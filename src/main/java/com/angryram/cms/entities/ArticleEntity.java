package com.angryram.cms.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Builder
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
	@Column(insertable=false, updatable=false)
	private Date created;
	@Getter @Setter
	private Date publishdate;
	@Getter @Setter
	@Column(insertable=false, updatable=false)
	private Integer langid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorid", insertable = false, updatable = false)
	private AuthorEntity author;
    
    @Getter @Setter
	@Column(insertable=false, updatable=false)
    private String title;
    @Getter @Setter
	@Column(insertable=false, updatable=false)
    private String subtitle;
    @Getter @Setter
	@Column(insertable=false, updatable=false)
    private String text;

	public ArticleEntity() {}

	public ArticleEntity(Integer id, Integer authorid, Integer categoryid, Integer mainimgid, Date created, Date publishdate, Integer langid, AuthorEntity author, String title, String subtitle, String text) {
		this.id = id;
		this.authorid = authorid;
		this.categoryid = categoryid;
		this.mainimgid = mainimgid;
		this.created = created;
		this.publishdate = publishdate;
		this.langid = langid;
		this.author = author;
		this.title = title;
		this.subtitle = subtitle;
		this.text = text;
	}
}
