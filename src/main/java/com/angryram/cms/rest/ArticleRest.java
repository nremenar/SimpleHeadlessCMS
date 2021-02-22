package com.angryram.cms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angryram.cms.entities.ArticleEntity;
import com.angryram.cms.repository.ArticleRepository;
import com.angryram.cms.repository.ContentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/public/article")
public class ArticleRest {
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ContentRepository content;
	
	@GetMapping(value = "/getAll")
	public List<ArticleEntity> getAllArticles(@RequestParam Integer langid){
		return articleRepository.getAllByLangId(langid);
	}
	
	@GetMapping(value = "/getAllByCategory")
	public List<ArticleEntity> getAllArticlesByCategory(@RequestParam Integer langid, @RequestParam Integer categoryid){
		return articleRepository.getAllByCategoryId(langid, categoryid);
	}
	
	@GetMapping(value = "/getAllByCategoryPagination")
	public List<ArticleEntity> getAllArticlesByCategoryAndPagination(@RequestParam Integer langid, @RequestParam Integer categoryid, @RequestParam Integer from, @RequestParam Integer to){
		return articleRepository.getAllArticlesByCategoryAndPagination(langid, categoryid, from, to);
	}
	
	@GetMapping(value = "/getById")
	public ArticleEntity getArticleById(@RequestParam Integer langid, @RequestParam Integer articleid){
		return articleRepository.getOneByIdAndLang(langid, articleid);
	}
	
	@GetMapping(value = "/getByAuthor")
	public List<ArticleEntity> getArticleByAuthor(@RequestParam Integer langid, @RequestParam Integer authorid){
		return articleRepository.getAllArticlesByAuthor(langid, authorid);
	}
	
	@GetMapping(value = "/getByAuthorPagination")
	public List<ArticleEntity> getArticleByAuthorPagination(@RequestParam Integer langid, @RequestParam Integer authorid, @RequestParam Integer from, @RequestParam Integer to){
		return articleRepository.getAllArticlesByAuthorPagination(langid, authorid, from, to);
	}
	
}
