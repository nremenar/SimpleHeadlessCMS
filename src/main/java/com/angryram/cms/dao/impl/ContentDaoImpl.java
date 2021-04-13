package com.angryram.cms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.angryram.cms.dao.ContentDao;
import com.angryram.cms.dto.ContentDto;


@Repository
public class ContentDaoImpl implements ContentDao{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ContentDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ContentDto> getByArticleId(Integer id) {
		String sql = "select * from content where articleid = ?";
		Object[] args = {id};
		return jdbcTemplate.query(sql,args, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}

	@Override
	public ContentDto getByArticleIdAndLangId(Integer articleId, Integer langId) {
		String sql = "select * from content where articleid = ? and langid = ?";
		Object[] args = {articleId, langId};
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ContentDto.class), args);
	}
}
