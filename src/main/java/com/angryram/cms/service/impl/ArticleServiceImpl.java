package com.angryram.cms.service.impl;

import com.angryram.cms.dto.ContentDto;
import com.angryram.cms.entities.ArticleEntity;
import com.angryram.cms.entities.LanguageEntity;
import com.angryram.cms.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angryram.cms.dao.ArticleDao;
import com.angryram.cms.dao.ContentDao;
import com.angryram.cms.dto.ArticleDto;
import com.angryram.cms.repository.AuthorRepository;
import com.angryram.cms.service.ArticleService;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired 
	ArticleDao articleDao;
	
	@Autowired
	ContentDao contentDao;
	
	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	LanguageRepository languages;

	@Override
	public ArticleDto getById(Integer id) {
		ArticleDto article = articleDao.getById(id);
		List<ContentDto> contents = contentDao.getByArticleId(id);
		List<LanguageEntity> langs  = languages.findAll();

		Set<Integer> langIds = langs.stream().map(LanguageEntity::getId).collect(Collectors.toSet());
		langIds.removeIf(contents.stream().map(ContentDto::getLangid).collect(Collectors.toSet())::remove);

		for(Integer missingLng: langIds){
			ContentDto cont = new ContentDto();
			cont.setLangid(missingLng);
			cont.setTitle("");
			cont.setSubtitle("");
			cont.setText("");
			contents.add(cont);
		}

		article.setContents(contents);
		article.setAuthor(authorRepository.findById(article.getAuthorid()));
		return article;

	}

	@Override
	public void saveArticle(Map<String, String> params) {
		List<LanguageEntity> langs  = languages.findAll();
		ArticleDto article = new ArticleDto();

		List<ContentDto> contents = new ArrayList<>();


		for(LanguageEntity lang : langs){
			System.out.print("title-"+lang.getId());
			System.out.print(params.get("title-"+lang.getId()));
			contents.add(ContentDto.builder().articleid(Integer.valueOf(params.get("articleId")))
					.title(params.get("title-"+lang.getId()))
					.subtitle(params.get("subtitle-"+lang.getId()))
					.text(params.get("text-"+lang.getId()))
					.langid(lang.getId())
					.build());
		}

		System.out.print(contents.size());


	}
}
