package com.angryram.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.angryram.cms.repository.LanguageRepository;
import com.angryram.cms.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	LanguageRepository languages;
	
	@GetMapping("/edit")
	public ModelAndView listallarticles(@RequestParam Integer id) {
		ModelAndView model = new ModelAndView();
		model.addObject("article", articleService.getById(id));
		model.addObject("languages", languages.findAll());
		model.setViewName("articleDetails");	
		return model;
	}
	
}

