package com.angryram.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angryram.cms.entities.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

}
