package com.angryram.cms.entities;

import java.io.Serializable;

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
@Table(name="author")
public class AuthorEntity implements Serializable {
	
	private static final long serialVersionUID = -4087970586697604468L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String email;
	
//	@Getter
//	@Setter
//	private String password;
	
}
