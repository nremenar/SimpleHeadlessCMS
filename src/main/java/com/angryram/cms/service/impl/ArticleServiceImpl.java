package com.angryram.cms.service.impl;

import com.angryram.cms.dto.ContentDto;
import com.angryram.cms.entities.ArticleEntity;
import com.angryram.cms.entities.ContentEntity;
import com.angryram.cms.entities.LanguageEntity;
import com.angryram.cms.repository.ArticleRepository;
import com.angryram.cms.repository.ContentRepository;
import com.angryram.cms.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angryram.cms.dao.ArticleDao;
import com.angryram.cms.dao.ContentDao;
import com.angryram.cms.dto.ArticleDto;
import com.angryram.cms.repository.AuthorRepository;
import com.angryram.cms.service.ArticleService;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	private final ArticleDao articleDao;
	private final ContentDao contentDao;
	private final AuthorRepository authorRepository;
	private final LanguageRepository languages;
	private final ArticleRepository articleRepository;
	private final ContentRepository contentRepository;

	@Autowired
	public ArticleServiceImpl(ArticleDao articleDao, ContentDao contentDao, AuthorRepository authorRepository, LanguageRepository languages, ArticleRepository articleRepository, ContentRepository contentRepository){
		this.articleDao = articleDao;
		this.contentDao = contentDao;
		this.authorRepository = authorRepository;
		this.languages = languages;
		this.articleRepository = articleRepository;
		this.contentRepository = contentRepository;;
	}

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
		if(params.get("articleId") == null || params.get("articleId").equals("")){
			List<LanguageEntity> langs  = languages.findAll();
			List<ContentEntity> contents = langs.stream().map(
					n -> {
						if(!(params.get("title-"+n.getId()).isEmpty() && params.get("subtitle-"+n.getId()).isEmpty() && params.get("text-"+n.getId()).isEmpty())){
							return ContentEntity.builder()
									.title(params.get("title-"+n.getId()))
									.subtitle(params.get("subtitle-"+n.getId()))
									.text(params.get("text-"+n.getId()))
									.langid(n.getId())
									.build();
						}
						return null;
					}
			).collect(Collectors.toList());
			contents.removeAll(Collections.singleton(null));
			if(contents.size() > 0){
				Integer articleid = articleRepository.save(ArticleEntity.builder().authorid(1).categoryid(1).build()).getId();
				contents.forEach(n -> n.setArticleid(articleid));
				contentRepository.saveAll(contents);
			}
		}
		else{
			List<LanguageEntity> langs  = languages.findAll();
			langs.forEach(
					n -> {
						System.out.print(n.getName());
						try {
							ContentDto existing = contentDao.getByArticleIdAndLangId(Integer.valueOf(params.get("articleId")), n.getId());
							existing.setSubtitle(params.get("subtitle-"+n.getId()));
							existing.setTitle(params.get("title-"+n.getId()));
							existing.setText(params.get("text-"+n.getId()));
							contentRepository.save(
									ContentEntity.builder()
									.articleid(existing.getArticleid())
									.title(existing.getTitle())
									.subtitle(existing.getSubtitle())
									.text(existing.getText())
									.langid(n.getId())
									.id(existing.getId())
									.build()
							);
						}
						catch (Exception e){

							if(!(params.get("title-"+n.getId()).isEmpty() && params.get("subtitle-"+n.getId()).isEmpty() && params.get("text-"+n.getId()).isEmpty())){
								ContentDto t = ContentDto.builder().articleid(Integer.valueOf(params.get("articleId")))
										.title(params.get("title-"+n.getId()))
										.subtitle(params.get("subtitle-"+n.getId()))
										.text(params.get("text-"+n.getId()))
										.langid(n.getId())
										.build();
								contentRepository.save(
										ContentEntity.builder()
												.articleid(Integer.valueOf(params.get("articleId")))
												.title(params.get("title-"+n.getId()))
												.subtitle(params.get("subtitle-"+n.getId()))
												.text(params.get("text-"+n.getId()))
												.langid(n.getId())
												.build()
								);
							}
						}
					}
			);
		}
	}
}
