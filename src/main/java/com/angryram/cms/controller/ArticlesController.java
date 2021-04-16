package com.angryram.cms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.angryram.cms.entities.ArticleEntity;
import com.angryram.cms.repository.ArticleRepository;

@Controller
public class ArticlesController {

	private final ArticleRepository articleRepository;

	@Autowired
	public ArticlesController(ArticleRepository articleRepository){
		this.articleRepository = articleRepository;

	}
	
	@GetMapping("/articles")
	public ModelAndView listallarticles() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 50);
		List<ArticleEntity> t = (List<ArticleEntity>) articleRepository.getAllByLangIdPagable(1, firstPageWithTwoElements);
		ModelAndView model = new ModelAndView();
		model.addObject("articles", t);
		model.setViewName("articles");		
		return model;
	}
	
	
	@GetMapping("/articles/list-paginated")
	public ResponseEntity<?> list(@RequestParam(value = "pageSize", required = false) Optional<Integer> pageSize,
			@RequestParam(value = "pageNumber", required = false) Optional<Integer> pageNumber,
			@RequestParam(value = "sort", required = false) Sort sort) {
		return ResponseEntity.ok("");
	}
	
}
