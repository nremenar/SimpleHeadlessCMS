package com.angryram.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angryram.cms.dao.ArticleDao;
import com.angryram.cms.dao.ContentDao;
import com.angryram.cms.dto.ArticleDto;
import com.angryram.cms.repository.AuthorRepository;
import com.angryram.cms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired 
	ArticleDao articleDao;
	
	@Autowired
	ContentDao contentDao;
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public ArticleDto getById(Integer id) {
		ArticleDto article = articleDao.getById(id);
		article.setContents(contentDao.getByArticleId(id));
		article.setAuthor(authorRepository.findById(article.getAuthorid()));
		return article;
	}
}
