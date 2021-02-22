package com.angryram.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angryram.cms.entities.CategoryNameEntity;

public interface CategoryNameRepository extends JpaRepository<CategoryNameEntity, Integer>{
	
	List<CategoryNameEntity> findByLangid(Integer langid);
}
