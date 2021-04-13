package com.angryram.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angryram.cms.entities.ContentEntity;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentEntity,Integer> {
	
//	@Query(value = "select c.* from content c "
//			 	 + "where c.langid = :langid and c.articleid = :articleid", nativeQuery = true)
//	ContentEntity findByArticleIdAndLangId(@Param("langid") Integer langid, @Param("articleid") Integer articleid);

    //List<ContentEntity> findAllByArticleId(Integer articleId);

}
