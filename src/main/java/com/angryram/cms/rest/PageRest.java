package com.angryram.cms.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageRest {
	@GetMapping(value = "/public/getAllPages")
	public List<String> getAllArticles(@RequestParam Long langId){
		return null;
	}
}
