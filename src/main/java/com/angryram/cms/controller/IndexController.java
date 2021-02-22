package com.angryram.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping(value = {"/index","index"})
	public ModelAndView getIndex() {
		ModelAndView model = new ModelAndView();
		return model;
	}
}
