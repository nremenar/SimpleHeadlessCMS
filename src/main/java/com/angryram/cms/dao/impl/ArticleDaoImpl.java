package com.angryram.cms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.angryram.cms.dao.ArticleDao;
import com.angryram.cms.dto.ArticleDto;

@Repository
public class ArticleDaoImpl implements ArticleDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ArticleDto getById(Integer id) {
		String sql = "select * from articles where id = ?";
		Object[] args = {id};
		return jdbcTemplate.queryForObject(sql,args, new BeanPropertyRowMapper<ArticleDto>(ArticleDto.class));

	}
	
}
