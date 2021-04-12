package com.angryram.cms.service;

import com.angryram.cms.dto.ArticleDto;

import java.util.Map;

public interface ArticleService {
	ArticleDto getById(Integer id);
	void saveArticle(Map<String, String> params);
}
