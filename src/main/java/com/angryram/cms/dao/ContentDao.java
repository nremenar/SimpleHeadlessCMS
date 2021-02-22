package com.angryram.cms.dao;

import java.util.List;

import com.angryram.cms.dto.ContentDto;

public interface ContentDao {
	List<ContentDto> getByArticleId(Integer id);
}
