package com.angryram.cms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.angryram.cms.entities.CategoryNameEntity;
import com.angryram.cms.repository.CategoryNameRepository;

@RestController
public class CategoryRest {
	
	@Autowired
	private CategoryNameRepository categoryNameRepository;
	
	@GetMapping(value = "/public/getallcategories")
	public List<CategoryNameEntity> getAllCategoriesByLang(@RequestParam Integer langid){
		return categoryNameRepository.findByLangid(langid);
	}

}