package com.angryram.cms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryid;
	
	@OneToMany(targetEntity=CategoryNameEntity.class, mappedBy="categoryid", fetch=FetchType.EAGER)
	private List<CategoryNameEntity> categorynames;
	
	public Integer getcategoryid(){
		return categoryid;
	}
	
	public void setcategoryid(Integer categoryId){
		categoryid = categoryId;
	}
	
}
