package com.angryram.cms.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.angryram.cms.entities.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer>{

	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, "
				 + "a.created, a.publishdate, c.langid, c.title, c.text, c.subtitle from content c join "
				 + "articles a on a.id = c.articleid where c.langid = :langid", nativeQuery = true)
	List<ArticleEntity> getAllByLangId(@Param("langid") Integer langid);
	
	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, "
			 + "a.created, a.publishdate, c.langid, c.title, c.text, c.subtitle from content c join "
			 + "articles a on a.id = c.articleid where c.langid = :langid", nativeQuery = true)
	List<ArticleEntity> getAllByLangIdPagable(@Param("langid") Integer langid, Pageable pageable);
	
	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, a.created, a.publishdate, c.title, c.subtitle, c.text, c.langid "
				 + "from content c "
				 + "join articles a on a.id = c.articleid "
				 + "join categoryname cn on cn.categoryid = a.categoryid and cn.langid = c.langid "
				 + "where c.langid = :langid and a.categoryid = :categoryId", nativeQuery = true)
	List<ArticleEntity> getAllByCategoryId(@Param("langid") Integer langid, @Param("categoryId") Integer categoryId);
	
	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, a.created, a.publishdate, c.title, c.subtitle "
				 + "from content c "
				 + "join articles a on a.id = c.articleid "
				 + "join categoryname cn on cn.categoryid = a.categoryid and cn.langid = c.langid "
				 + "join author au on au.id = a.authorid"
				 + "where c.langid = :langid and a.categoryid = :categoryId limit :from, :to", 
				 nativeQuery = true)
	List<ArticleEntity> getAllArticlesByCategoryAndPagination(@Param("langid") Integer langid, 
															  @Param("categoryId") Integer categoryId, 
															  @Param("from") Integer from,
															  @Param("to") Integer to);
	
	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, a.created, a.publishdate, c.title, c.subtitle, c.text, c.langid "
				 + "from content c join articles a on a.id = c.articleid where c.langid = :langid and a.id = :articleId", nativeQuery = true)
	ArticleEntity getOneByIdAndLang(@Param("langid") Integer Integer, @Param("articleId") Integer articleId);
	
	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, a.created, a.publishdate, c.title, c.subtitle, c.text, c.langid "
			 + "from content c join articles a on a.id = c.articleid where c.langid = :langid and a.authorid = :authorid", nativeQuery = true)
	List<ArticleEntity> getAllArticlesByAuthor(@Param("langid") Integer langid, @Param("authorid") Integer authorid);
	
	
	@Query(value = "select a.id, a.authorid, a.categoryid, a.mainimgid, a.created, a.publishdate, c.title, c.subtitle, c.text, c.langid "
			 + "from content c join articles a on a.id = c.articleid where c.langid = :langid and a.authorid = :authorid limit :from, :to", nativeQuery = true)
	List<ArticleEntity> getAllArticlesByAuthorPagination(@Param("langid") Integer langid, @Param("authorid") Integer authorid, @Param("from") Integer from, @Param("to") Integer to);
}
