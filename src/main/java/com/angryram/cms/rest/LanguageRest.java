package com.angryram.cms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angryram.cms.entities.LanguageEntity;
import com.angryram.cms.repository.LanguageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/public")
public class LanguageRest {
	

	private final LanguageRepository languageRepository;

	@Autowired
	public LanguageRest(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}
	
	@GetMapping(value = "/getlanguages")
	public List<LanguageEntity> getAllArticles(){
		return languageRepository.findAll();
	}

}
