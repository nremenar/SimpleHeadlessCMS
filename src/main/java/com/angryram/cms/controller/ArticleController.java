package com.angryram.cms.controller;

import com.angryram.cms.entities.ArticleEntity;
import com.angryram.cms.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.angryram.cms.repository.LanguageRepository;
import com.angryram.cms.service.ArticleService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	LanguageRepository languages;

	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping("/edit")
	public ModelAndView articleDetails(@RequestParam Integer id) {
		ModelAndView model = new ModelAndView();
		model.addObject("article", articleService.getById(id));
		model.addObject("languages", languages.findAll());
		model.setViewName("articleDetails");	
		return model;
	}

	@GetMapping("/new")
	public ModelAndView articleNew() {
		ModelAndView model = new ModelAndView();
		model.addObject("languages", languages.findAll());
		model.setViewName("articleNew");
		return model;
	}

	@PostMapping("/save")
	public ModelAndView saveArticle(@RequestParam Map<String, String> reqParam) {

		articleService.saveArticle(reqParam);

		Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
		List<ArticleEntity> t = articleRepository.getAllByLangIdPagable(1, firstPageWithTwoElements);
		ModelAndView model = new ModelAndView();
		model.addObject("articles", t);
		model.setViewName("articles");
		return model;
	}
	
}

