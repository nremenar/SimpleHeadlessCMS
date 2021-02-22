package com.angryram.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.angryram.cms.entities.ArticleEntity;
import com.angryram.cms.repository.ArticleRepository;

@Controller
public class ArticlesController {

	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping("/articles")
	public ModelAndView listallarticles() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

		List<ArticleEntity> t = (List<ArticleEntity>) articleRepository.getAllByLangIdPagable(1, firstPageWithTwoElements);
		ModelAndView model = new ModelAndView();
		model.addObject("articles", t);
		model.setViewName("articles");
		
		return model;
	}
}
